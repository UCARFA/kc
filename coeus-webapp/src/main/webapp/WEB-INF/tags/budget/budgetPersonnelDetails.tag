<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/kr/WEB-INF/jsp/tldHeader.jsp"%>

<c:set var="budgetLineItemAttributes" value="${DataDictionary.BudgetLineItem.attributes}" />
<c:set var="budgetPersonnelDetailsAttributes" value="${DataDictionary.BudgetPersonnelDetails.attributes}" />
<c:set var="budgetPersonAttributes" value="${DataDictionary.BudgetPerson.attributes}" />

<c:set var="budgetPeriodNumber" value='<%=request.getAttribute("budgetPeriod")%>' />
<c:set var="budgetLineItemNumber" value='<%=request.getAttribute("lineNumber")%>' />
<c:set var="personNumber" value='<%=request.getAttribute("personNumber")%>' />

<c:set var="budgetLineItem" value="${KualiForm.document.budget.budgetPeriods[budgetPeriodNumber - 1].budgetLineItems[budgetLineItemNumber]}"/>

<c:set var="readOnly" value="${not KualiForm.editingMode['modifyBudgets']}" scope="request" />
<c:if test="${readOnly}" >
	<c:set var="budgetExpensePanelReadOnly" value="true" />
</c:if>

<kul:tabTop defaultOpen="true" tabTitle="Personnel Budget Details" tabErrorKey="*">
	<div class="tab-container" align="center">
	   <h3>
       		<span class="subhead-left">Personnel Budget Details - ${KualiForm.document.budget.budgetPeriods[budgetPeriod - 1].budgetLineItems[budgetLineItemNumber].budgetPersonnelDetailsList[personNumber].budgetPerson.personName}</span>       		
       </h3>	
		<div>
		
		<input type="hidden" name="budgetPeriod" value="${budgetPeriodNumber}" />
		<input type="hidden" name="line" value="${budgetLineItemNumber}" />
		<input type="hidden" name="personnelIndex" value="${personNumber}" />
		
		<table id="details-table" cellpadding=0 cellspacing=0 summary="" width="80%">
        	<tr>
        		<th width="20%"><div align="right">Effective Period</div></th>
        		<td width="40%"><div align="left">
        			<kul:htmlControlAttribute property="document.budget.budgetPeriod[${budgetPeriod - 1}].budgetLineItem[${budgetLineItemNumber}].budgetPersonnelDetailsList[${personNumber}].startDate" attributeEntry="${budgetPersonnelDetailsAttributes.startDate}" readOnly="true"/>
        			&nbsp;to&nbsp;
        			<kul:htmlControlAttribute property="document.budget.budgetPeriod[${budgetPeriod - 1}].budgetLineItem[${budgetLineItemNumber}].budgetPersonnelDetailsList[${personNumber}].endDate" attributeEntry="${budgetPersonnelDetailsAttributes.endDate}" readOnly="true"/>
        		</div></td>
        	</tr>
       		<tr>
        		<th width="20%"><div align="right"><kul:htmlAttributeLabel attributeEntry="${budgetPersonnelDetailsAttributes.percentEffort}" noColon="true" /></div></th>
        		<td width="40%"><div align="left">
        			<kul:htmlControlAttribute property="document.budget.budgetPeriod[${budgetPeriod - 1}].budgetLineItem[${budgetLineItemNumber}].budgetPersonnelDetailsList[${personNumber}].percentEffort" attributeEntry="${budgetPersonnelDetailsAttributes.percentEffort}" readOnly="true"/>
        		</div></td>
        	</tr>
			<tr>
        		<th width="20%"><div align="right"><kul:htmlAttributeLabel attributeEntry="${budgetPersonnelDetailsAttributes.percentCharged}" noColon="true" /></div></th>
        		<td width="40%"><div align="left">
        			<kul:htmlControlAttribute property="document.budget.budgetPeriod[${budgetPeriod - 1}].budgetLineItem[${budgetLineItemNumber}].budgetPersonnelDetailsList[${personNumber}].percentCharged" attributeEntry="${budgetPersonnelDetailsAttributes.percentCharged}" readOnly="true"/>
        		</div></td>
        	</tr>
        	<tr>
        		<td width="60%" style="background-color: #e4e4e4" colspan="2">&nbsp;</td>
        	</tr>
        	<tr>
        		<th width="20%"><div align="right"><kul:htmlAttributeLabel attributeEntry="${budgetPersonnelDetailsAttributes.lineItemDescription}" noColon="true" /></div></th>
        		<td width="40%"><div align="left">
        			<kul:htmlControlAttribute property="document.budget.budgetPeriod[${budgetPeriod - 1}].budgetLineItem[${budgetLineItemNumber}].budgetPersonnelDetailsList[${personNumber}].lineItemDescription" attributeEntry="${budgetPersonnelDetailsAttributes.lineItemDescription}" readOnly="${budgetExpensePanelReadOnly}"/>
        		</div></td>
        	</tr>
			<tr>
        		<th width="20%"><div align="right"><kul:htmlAttributeLabel attributeEntry="${budgetPersonnelDetailsAttributes.underrecoveryAmount}" noColon="true" /></div></th>
        		<td width="40%"><div align="left">
        			<kul:htmlControlAttribute property="document.budget.budgetPeriod[${budgetPeriod - 1}].budgetLineItem[${budgetLineItemNumber}].budgetPersonnelDetailsList[${personNumber}].underrecoveryAmount" attributeEntry="${budgetPersonnelDetailsAttributes.underrecoveryAmount}" readOnly="true"/>
        		</div></td>
        	</tr>
			<tr>
        		<th width="20%"><div align="right"><kul:htmlAttributeLabel attributeEntry="${budgetPersonnelDetailsAttributes.costSharingAmount}" noColon="true" /></div></th>
        		<td width="40%"><div align="left">
        			<kul:htmlControlAttribute property="document.budget.budgetPeriod[${budgetPeriod - 1}].budgetLineItem[${budgetLineItemNumber}].budgetPersonnelDetailsList[${personNumber}].costSharingAmount" attributeEntry="${budgetPersonnelDetailsAttributes.costSharingAmount}" readOnly="true"/>
        		</div></td>
        	</tr>
			<tr>
        		<th width="20%"><div align="right"><kul:htmlAttributeLabel attributeEntry="${budgetPersonnelDetailsAttributes.costSharingPercent}" noColon="true" /></div></th>
        		<td width="40%"><div align="left">
        			<kul:htmlControlAttribute property="document.budget.budgetPeriod[${budgetPeriod - 1}].budgetLineItem[${budgetLineItemNumber}].budgetPersonnelDetailsList[${personNumber}].costSharingPercent" attributeEntry="${budgetPersonnelDetailsAttributes.costSharingPercent}" readOnly="true"/>
        		</div></td>
        	</tr>
        	<tr>
        		<th width="20%"><div align="right">Person Months</div></th>
        		<td width="40%"><div align="left">
        			<c:out value="${KualiForm.document.budget.budgetPeriods[budgetPeriod - 1].budgetLineItems[budgetLineItemNumber].budgetPersonnelDetailsList[personNumber].personMonths}" />
        		</div></td>
        	</tr>
        </table>
    </div>
</kul:tabTop>  
