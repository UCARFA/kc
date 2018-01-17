<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="top" required="true" %>
<c:set var="readOnly" value="${not KualiForm.editingMode['modifyBudgets']}" scope="request" />
<c:set var="budgetDocumentAttributes" value="${DataDictionary.Budget.attributes}" />

<c:if test="${top == 'true'}">
    <kul:tabTop tabTitle="Budget Justification" defaultOpen="false" tabErrorKey="budgetJustificationWrapper.*">
	<div class="tab-container" align="center">
		<h3>
	    	<span class="subhead-left">Budget Justification</span>
   			<span class="subhead-right"><kul:help parameterNamespace="KC-AB" parameterDetailType="Document" parameterName="awardBudgetActionJustificationHelpUrl" altText="help"/></span>
	   	</h3>
		<div align="center">
			<table id="budget-justification-table" cellpadding="0" cellspacing="0" summary="Budget Justification">
				<tr>
					<th><div align="center">Last Updated Timestamp</div></th>
					<th><div align="center">Updated By</div></th>
					<th><div align="center">Justification Text</div></th>
				</tr>
				<tr>
	            	<td width="10%"><div align="center">${KualiForm.budgetJustification.lastUpdateTime}</div>&nbsp;</td>
	            	<td width="10%"><div align="center">${KualiForm.budgetJustification.lastUpdateUser}</div>&nbsp;</td>
	            	<td width="80%">
	            		<div align="center">
	            			<html:textarea rows="8" cols="60" property="budgetJustification.justificationText" readonly="${readOnly}" />
	            		</div>
	            	</td>
	            </tr>
			</table>
			<div align=center style="padding-top: 2em;">
				<html:image property="methodToCall.consolidateExpenseJustifications" src='${ConfigProperties.kra.externalizable.images.url}buttonsmall_consolidate_expense_justifications.gif' styleClass="tinybutton"/>
			</div>
		</div>					
	</div>
 </kul:tabTop>
</c:if>
<c:if test="${top == 'false'}">
   <kul:tab tabTitle="Budget Justification" defaultOpen="false" tabErrorKey="budgetJustificationWrapper.*">
    <div class="tab-container" align="center">
        <h3>
            <span class="subhead-left">Budget Justification</span>
            <span class="subhead-right"><kul:help parameterNamespace="KC-B" parameterDetailType="Document" parameterName="budgetActionJustificationHelpUrl" altText="help"/></span>
        </h3>
        <div align="center">
            <table id="budget-justification-table" cellpadding="0" cellspacing="0" summary="Budget Justification">
                <tr>
                    <th><div align="center">Last Updated Timestamp</div></th>
                    <th><div align="center">Updated By</div></th>
                    <th><div align="center">Justification Text</div></th>
                </tr>
                <tr>
                    <td width="10%"><div align="center">${KualiForm.budgetJustification.lastUpdateTime}</div>&nbsp;</td>
                    <td width="10%"><div align="center">${KualiForm.budgetJustification.lastUpdateUser}</div>&nbsp;</td>
                    <td width="80%">
                        <div align="center">
                            <html:textarea rows="8" cols="60" property="budgetJustification.justificationText" readonly="${readOnly}" />
                        </div>
                    </td>
                </tr>
            </table>
            <c:if test="${!readOnly}">
	            <div align=center style="padding-top: 2em;">
	                <html:image property="methodToCall.consolidateExpenseJustifications" src='${ConfigProperties.kra.externalizable.images.url}buttonsmall_consolidate_expense_justifications.gif' styleClass="tinybutton"/>
	            </div>
            </c:if>
        </div>                  
    </div>
 </kul:tab>
</c:if>
