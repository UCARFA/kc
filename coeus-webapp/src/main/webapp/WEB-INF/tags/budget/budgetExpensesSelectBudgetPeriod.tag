<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="budgetPeriodAttributes" value="${DataDictionary.BudgetPeriod.attributes}" />

<c:set var="action" value="budgetExpensesAction" />

<kra:uncollapsable tabTitle="Select Budget Period:" tabErrorKey="viewBudgetPeriod">
       <div align="center">
           <table cellpadding="0" cellspacing="0" class="grid" summary="">
             <tr>
               <th class="grid"><div align="right">Budget Period:</div></th>                
               <td class="grid" >
               	<kul:htmlControlAttribute readOnly="false" property="viewBudgetPeriod" attributeEntry="${budgetPeriodAttributes.budgetPeriod}" />
               </td>
               <th class="grid"><div align="right">View:</div></th>
               <td class="grid" >
					<html:select property="viewBudgetView"> 
	                    	<html:option value="0">Full Detail</html:option>  		                    	
	                    	<html:option value="1">Simple Detail</html:option>
  			       	</html:select>
               </td>
             </tr>
           </table>
           <br>
           <html:image property="methodToCall.updateBudgetPeriodView" src="${ConfigProperties.kra.externalizable.images.url}tinybutton-updateview.gif" title="Update View" alt="Update View" styleClass="tinybutton"/>
	</div>
</kra:uncollapsable>
