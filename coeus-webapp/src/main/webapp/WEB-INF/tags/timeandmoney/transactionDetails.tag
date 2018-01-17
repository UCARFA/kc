<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="awardAmountInfoHistory" description="awardAmountInfoHistory" required="true" type="org.kuali.kra.timeandmoney.AwardAmountInfoHistory"%>

<c:set var="transactionDetailAttributes" value="${DataDictionary.TransactionDetail.attributes}" />
<c:set var="tabTitleAttribute" value="Transaction ID:" />
<c:set var="idValue" value="${awardAmountInfoHistory.primaryDetail.transactionDetailId}" />

<kul:innerTab parentTab="History" defaultOpen="false" tabTitle="Transaction Details/${tabTitleAttribute} ${idValue}" tabErrorKey="" >
	<table border="0" cellpadding="0" cellspacing="0" summary="">
        <tr>
        	<th width="65%">
				<div align="center"><kul:htmlAttributeLabel attributeEntry="${transactionDetailAttributes.comments}" readOnly="true" noColon="true" /></div>
   			</th>
   			<th>
				<div align="center"><kul:htmlAttributeLabel attributeEntry="${transactionDetailAttributes.sourceAwardNumber}" readOnly="true" noColon="true" /></div>
   			</th>
   			<th>
				<div align="center"><kul:htmlAttributeLabel attributeEntry="${transactionDetailAttributes.destinationAwardNumber}" readOnly="true" noColon="true" /></div>
   			</th>
   			<th>
				<div align="center"><kul:htmlAttributeLabel attributeEntry="${transactionDetailAttributes.obligatedAmount}" readOnly="true" noColon="true" /></div>
   			</th>
   			<th>
				<div align="center"><kul:htmlAttributeLabel attributeEntry="${transactionDetailAttributes.anticipatedAmount}" readOnly="true" noColon="true" /></div>
   			</th>
   		</tr>
   		<tr>
   			<td align="left" class="infoline" rowspan="${awardAmountInfoHistory.transactionDetailTableSize}">
	          	<div align="center">
                	${awardAmountInfoHistory.primaryDetail.comments}
	            </div>                	
			</td>
			<td style="font-weight:bold">
				<div align="center">
					${awardAmountInfoHistory.primaryDetail.sourceAwardNumber}
				</div>
			</td>
			<td style="font-weight:bold">
				<div align="center">
					${awardAmountInfoHistory.primaryDetail.destinationAwardNumber}
				</div>
			</td>
			<td style="font-weight:bold">
				<div align="center">
					${awardAmountInfoHistory.primaryDetail.obligatedAmount}
				</div>
			</td>
			<td style="font-weight:bold">
				<div align="center">
					${awardAmountInfoHistory.primaryDetail.anticipatedAmount}
				</div>
			</td>
   		</tr>
   		<c:forEach var="transactionDetail" items="${awardAmountInfoHistory.intermediateDetails}" varStatus="status"> 
   			<tr>
				<td>
					<div align="center">
						${transactionDetail.sourceAwardNumber}
					</div>
				</td>
				<td>
					<div align="center">
						${transactionDetail.destinationAwardNumber}
					</div>
				</td>
				<td>
					<div align="center">
						${transactionDetail.obligatedAmount}
					</div>
				</td>
				<td>
					<div align="center">
						${transactionDetail.anticipatedAmount}
					</div>
				</td>
   			</tr>
   		</c:forEach>
	</table>
</kul:innerTab>	
   		
   		
   		
   		
   		
   		
   		
