<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:tabTop tabTitle="Print Forms" defaultOpen="false" tabErrorKey="">
    <c:set var="disableBox" value = "true" />
	<c:forEach var="budgetPeriod" items="${KualiForm.document.budget.budgetPeriods}" varStatus="idx">
	    <c:if test="${fn:length(budgetPeriod.budgetLineItems) > 0}" >
    		<c:set var="disableBox" value = "false" />
	    </c:if>
	</c:forEach>
	<div class="tab-container" align="center">
		<table cellspacing="0" cellpadding="0" summary="">
			<tbody>
				<tr>
				 <td colspan="2" width="65%" style="padding: 0;border: 0">
						<h3>
							<div align="center">
								<span align="left">Print Forms</span>
							</div>
						</h3>
					</td>
					<td align="center" style="padding: 0;border: 0" width="25%">
						<h3>
							<div align="center">
								<span align="center">Print Budget Comments</span>
							</div>
						</h3>
					</td>
					<td style="padding: 0;border: 0" width="10%">
						<h3>
							<div align="center">
								<span align="center">Actions</span>
   								<span class="subhead-right"><kul:help parameterNamespace="KC-AB" parameterDetailType="Document" parameterName="awardBudgetActionPrintFormsHelpUrl" altText="help"/></span>
							</div>
						</h3>
					</td>
				</tr> 
				
				<c:forEach var="form" items="${KualiForm.document.budget.budgetPrintForms}" varStatus="status">
		            <tr>	                
		                <td width="3%">
		                	<c:out value="${status.index + 1 }"/>
		                </td>
		                <td align="left" valign="middle">
		                	<c:out value="${KualiForm.document.budget.budgetPrintForms[status.index].budgetReportName}"/>
						</td>
		                <td align="center" valign="middle" >
		                	<div align="center">
		                			<html:multibox  property="selectedToPrintComment"  value="${KualiForm.document.budget.budgetPrintForms[status.index].budgetReportId}" />
		                	</div>
		                </td>
						<td align="center" valign="middle"">
							<div align="center">
								<html:image
									property="methodToCall.printBudgetForm.line${status.index}.anchor${currentTabIndex}"
									src='${ConfigProperties.kra.externalizable.images.url}tinybutton-print.gif'
									styleClass="tinybutton" alt="Print Selected Forms"
									onclick="excludeSubmitRestriction=true" />
							</div></td>
					</tr>    	
		    	</c:forEach>		
		    	    	
			<tbody id="G" style="display: none;" />
			</tbody>
		</table>
	</div>
</kul:tabTop>
