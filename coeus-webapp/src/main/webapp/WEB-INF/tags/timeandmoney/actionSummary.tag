<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="awardAmountInfoAttributes" value="${DataDictionary.AwardAmountInfo.attributes}" />
<c:set var="awardAmountTransactionAttributes" value="${DataDictionary.AwardAmountTransaction.attributes}" />

<kul:tab tabTitle="Action Summary (${KualiForm.document.awardNumber})" defaultOpen="false" tabErrorKey="">
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left"> Action Summary</span>
    		<span class="subhead-right"><kul:help parameterNamespace="KC-T" parameterDetailType="Document" parameterName="tmActionSummaryHelpUrl" altText="help"/></span>
  </h3>
        
        <table cellpadding="0" cellspacing="0" summary="">
        	<tr>
        		<th>
					<div align="center"><kul:htmlAttributeLabel attributeEntry="${awardAmountTransactionAttributes.noticeDate}" readOnly="true" noColon="true" /></div>
       			</th>
       			<th>
					<div align="center"><kul:htmlAttributeLabel attributeEntry="${awardAmountTransactionAttributes.transactionTypeCode}" readOnly="true" noColon="true" /></div>
       			</th>
       			
        		<th>
					<div align="center"><kul:htmlAttributeLabel attributeEntry="${awardAmountInfoAttributes.currentFundEffectiveDate}" readOnly="true" noColon="true" /></div>
       			</th>
       			<th>
					<div align="center"><kul:htmlAttributeLabel attributeEntry="${awardAmountInfoAttributes.obligationExpirationDate}" readOnly="true" noColon="true" /></div>
       			</th>
       			<th>
					<div align="center"><kul:htmlAttributeLabel attributeEntry="${awardAmountInfoAttributes.amountObligatedToDate}" readOnly="true" noColon="true" /></div>
       			</th>
       			<th>
					<div align="center"><kul:htmlAttributeLabel attributeEntry="${awardAmountInfoAttributes.obligatedChange}" readOnly="true" noColon="true" /></div>
       			</th>        	
        	</tr>
        	<c:forEach var="timeAndMoneyActionSummaryItems" items="${KualiForm.document.timeAndMoneyActionSummaryItems}" varStatus="status">
        	<tr>
        		<td class="datacell"><div>
        			<fmt:formatDate value="${timeAndMoneyActionSummaryItems.noticeDate}" pattern="MM/dd/yyyy" />
				</div></td>
				<td class="datacell"><div>								        		
					${timeAndMoneyActionSummaryItems.transactionType}
				</div></td>
				<td class="datacell"><div>
					<fmt:formatDate value="${timeAndMoneyActionSummaryItems.obligationStartDate}" pattern="MM/dd/yyyy" />
				</div></td>
				<td class="datacell"><div>
					<fmt:formatDate value="${timeAndMoneyActionSummaryItems.obligationEndDate}" pattern="MM/dd/yyyy" />
				</div></td>
				<td class="datacell"><div>				        		
					<fmt:formatNumber type="currency" currencySymbol="" value="${timeAndMoneyActionSummaryItems.obligationCumulative}"/>
				</div></td>
				<td class="datacell"><div>				        		
					<fmt:formatNumber type="currency" currencySymbol="" value="${timeAndMoneyActionSummaryItems.changeAmount}"/>
				</div></td>
        	</tr>
        	</c:forEach>
        
        </table>
    </div>    
</kul:tab>
