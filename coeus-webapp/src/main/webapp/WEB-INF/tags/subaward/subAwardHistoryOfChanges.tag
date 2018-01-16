<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="htmlFormAction" required="false" %>
<%@ attribute name="renderMultipart" required="false" %>
<c:set var="subAwardAmountInfoAttributes" value="${DataDictionary.SubAwardAmountInfo.attributes}" />
<c:set var="subAwardAttributes" value="${DataDictionary.SubAward.attributes}" />
<c:set var="costSplitEnabled" value="${KualiForm.costSplitEnabled}" />

<c:set var="action" value="subAwardFinancial" />

<c:set var="newSubAwardAmountInfo" value="${KualiForm.newSubAwardAmountInfo}" />

<kul:tab tabTitle="History of Changes" defaultOpen="true" alwaysOpen="true" transparentBackground="true" tabErrorKey="subAwardAmountInfoErrors,newSubAwardAmountInfo.periodofPerformanceStartDate,newSubAwardAmountInfo.effectiveDate*,newSubAwardAmountInfo.obligatedChange*,newSubAwardAmountInfo.anticipatedChange*,newSubAwardAmountInfo.comments*,newSubAwardAmountInfo.modificationTypeCode,document.subAwardList[0].allSubAwardAmountInfos*,document.subAwardList[0].modificationId,document.subAwardList[0].totalAnticipatedAmount*,document.subAwardList[0].totalObligatedAmount*" auditCluster="subawardFinancialdAuditErrors" tabAuditKey="document.subAwardList[0].totalAnticipatedAmount*,document.subAwardList[0].totalObligatedAmount*" useRiceAuditMode="true">
	<div class="tab-container" align="center">
	<h3>
    	<span class="subhead-left"></span>
    	<span class="subhead-right"></span>
    </h3>
	<table cellpadding=0 cellspacing=0 summary="">
        <tr>
            <th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalObligatedAmount}" /></th>
            <td colspan="2">
                <kul:htmlControlAttribute property="document.subAwardList[0].totalObligatedAmount" disabled="true" attributeEntry="${subAwardAttributes.totalObligatedAmount}" />
            </td>
            <th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalAnticipatedAmount}" /></th>
            <td colspan="2">
                <kul:htmlControlAttribute property="document.subAwardList[0].totalAnticipatedAmount" disabled="true" attributeEntry="${subAwardAttributes.totalAnticipatedAmount}" />
            </td>
        </tr>
        <c:choose>
            <c:when test="${costSplitEnabled}">
                <tr>
                    <th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalObligatedDirectAmount}" /></th>
                    <td colspan="2">
                        <kul:htmlControlAttribute property="document.subAwardList[0].totalObligatedDirectAmount" disabled="true" attributeEntry="${subAwardAttributes.totalObligatedDirectAmount}" />
                    </td>
                    <th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalObligatedIndirectAmount}" /></th>
                    <td colspan="2">
                        <kul:htmlControlAttribute property="document.subAwardList[0].totalObligatedIndirectAmount" disabled="true" attributeEntry="${subAwardAttributes.totalObligatedIndirectAmount}" />
                    </td>
                </tr>
                <tr>
                    <th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalAnticipatedDirectAmount}" /></th>
                    <td colspan="2">
                        <kul:htmlControlAttribute property="document.subAwardList[0].totalAnticipatedDirectAmount" disabled="true" attributeEntry="${subAwardAttributes.totalAnticipatedDirectAmount}" />
                    </td>
                    <th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalAnticipatedIndirectAmount}" /></th>
                    <td colspan="2">
                        <kul:htmlControlAttribute property="document.subAwardList[0].totalAnticipatedIndirectAmount" disabled="true" attributeEntry="${subAwardAttributes.totalAnticipatedIndirectAmount}" />
                    </td>
                </tr>
            </c:when>
        </c:choose>
            <tr>
				<th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalAmountReleased}" /></th>
                <td colspan="2">
                        <kul:htmlControlAttribute property="document.subAwardList[0].totalAmountReleased" disabled="true" attributeEntry="${subAwardAttributes.totalAmountReleased}" />           
                </td>
				<th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalAvailableAmount}" /></th>
                <td colspan="2">
                      <kul:htmlControlAttribute property="document.subAwardList[0].totalAvailableAmount" disabled="true" attributeEntry="${subAwardAttributes.totalAvailableAmount}" />           
                </td>
            </tr>
            
            <tr>
				<th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.modificationEffectiveDate}" /></th>
                <td colspan="2">
                
                     <kul:htmlControlAttribute property="document.subAwardList[0].modificationEffectiveDate" disabled="true" attributeEntry="${subAwardAttributes.modificationEffectiveDate}" datePicker="false"/>           
                </td>
				<th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.modificationId}" /></th>
                <td colspan="2">
                      <kul:htmlControlAttribute property="document.subAwardList[0].modificationId" disabled="true" attributeEntry="${subAwardAttributes.modificationId}" expandedTextArea="false" />
                </td>
            </tr>    
            
            <tr>
				<th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.performanceStartDate}" /></th>
                <td colspan="2">
                
                     <kul:htmlControlAttribute property="document.subAwardList[0].performanceStartDate" disabled="true" attributeEntry="${subAwardAttributes.performanceStartDate}" datePicker="false"/>           
                </td>
				<th><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.performanceEnddate}" /></th>
                <td colspan="2">
                      <kul:htmlControlAttribute property="document.subAwardList[0].performanceEnddate" disabled="true" attributeEntry="${subAwardAttributes.performanceEnddate}" datePicker="false"/>           
                </td>
            </tr> 
            
            </table>
    	<h3>
    		<span class="subhead-left">History of Changes</span>
            <div align="right"><kul:help parameterNamespace="KC-SUBAWARD" parameterDetailType="Document" parameterName="subAwardHistoryOfChangesHelpUrl" altText="help"/></div>
        </h3>
         
   <table cellpadding=0 cellspacing=0 summary="">
       		<tbody class="addline">            
            <tr>
                <c:choose>
                    <c:when test="${!costSplitEnabled}">
                        <th><div align="left">&nbsp;</div></th>
                        <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.effectiveDate}" /></div></th>
                        <th><div align="center">*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.obligatedChange}" /></div></th>
                        <th><div align="center">*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.anticipatedChange}" /></div></th>
                        <th colspan="2"><div align="center">&nbsp;</div></th>
                    </c:when>
                    <c:otherwise>
                        <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.effectiveDate}" /></div></th>
                        <th><div align="center">*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.obligatedChangeDirect}" /></div></th>
                        <th><div align="center">*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.obligatedChangeIndirect}" /></div></th>
                        <th><div align="center">*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.anticipatedChangeDirect}" /></div></th>
                        <th><div align="center">*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.anticipatedChangeIndirect}" /></div></th>
                        <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.rate}" /></div></th>
                    </c:otherwise>
                </c:choose>
            </tr>
            <tr>
              <c:if test="${readOnly!='true'}">

                    <c:choose>
                        <c:when test="${!costSplitEnabled}">
                            <th><div align="left">&nbsp;</div></th>
                            <td><div align="center">
                                <kul:htmlControlAttribute property="newSubAwardAmountInfo.effectiveDate" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.effectiveDate}" datePicker="true"/>
                            </div>
                            </td>
                            <td>
                                <div align="center">
     					            <kul:htmlControlAttribute property="newSubAwardAmountInfo.obligatedChange" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.obligatedChange}" />
   					            </div>
   				            </td>
   				            <td>
                            <div align="center">
     					        <kul:htmlControlAttribute property="newSubAwardAmountInfo.anticipatedChange" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.anticipatedChange}" />
   					        </div>
   				            </td>
                        </c:when>
                        <c:otherwise>
                            <td><div align="center">
                                <kul:htmlControlAttribute property="newSubAwardAmountInfo.effectiveDate" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.effectiveDate}" datePicker="true"/>
                            </div>
                            </td>
                            <td>
                                <div align="center">
                                    <kul:htmlControlAttribute property="newSubAwardAmountInfo.obligatedChangeDirect" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.obligatedChangeDirect}" />
                                </div>
                            </td>
                            <td>
                                <div align="center">
                                    <kul:htmlControlAttribute property="newSubAwardAmountInfo.obligatedChangeIndirect" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.obligatedChangeIndirect}" />
                                </div>
                            </td>
                            <td>
                                <div align="center">
                                    <kul:htmlControlAttribute property="newSubAwardAmountInfo.anticipatedChangeDirect" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.anticipatedChangeDirect}" />
                                </div>
                            </td>
                            <td>
                                <div align="center">
                                    <kul:htmlControlAttribute property="newSubAwardAmountInfo.anticipatedChangeIndirect" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.anticipatedChangeIndirect}" />
                                </div>
                            </td>
                            <td>
                                <div align="center">
                                    <kul:htmlControlAttribute property="newSubAwardAmountInfo.rate" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.rate}" />%
                                </div>
                            </td>
                        </c:otherwise>
                    </c:choose>

   				   <td class="infoline" colspan="2">

                   </td>

   			    </tr>
   			
   			<tr>
   				<th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.modificationTypeCode}" /></div></th>
            	<th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.modificationEffectiveDate}" /></div></th>
            	<th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.modificationID}" /></div></th>
            	<th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.periodofPerformanceStartDate}" /></div></th>
            	<th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.periodofPerformanceEndDate}" /></div></th>
            </tr>
            
            <tr>
              <td>
              	<div align="center">
     			  <kul:htmlControlAttribute property="newSubAwardAmountInfo.modificationTypeCode" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.modificationTypeCode}"/>           
   				</div> 
   			  </td>
            
            <td><div align="center">
     					<kul:htmlControlAttribute property="newSubAwardAmountInfo.modificationEffectiveDate" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.modificationEffectiveDate}" datePicker="true"/>           
   					</div> 
   				</td>
   				
   				<td><div align="center">
     					<kul:htmlControlAttribute property="newSubAwardAmountInfo.modificationID" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.modificationID}" />           
   					</div> 
   				</td>
   				
   				<td><div align="center">
     					<kul:htmlControlAttribute property="newSubAwardAmountInfo.periodofPerformanceStartDate" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.periodofPerformanceStartDate}" datePicker="true"/>           
   					</div> 
   				</td>
   				
   				<td><div align="center">
     					<kul:htmlControlAttribute property="newSubAwardAmountInfo.periodofPerformanceEndDate" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.periodofPerformanceEndDate}" datePicker="true"/>           
   					</div> 
   				</td>
   				</tr>
   				
        	<tr>
				<th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.comments}" /></div></th>
                <td align="center">
                      <kul:htmlControlAttribute property="newSubAwardAmountInfo.comments" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.comments}" />
                </td>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.fileName}" /></div></th>
                <td align="center">
                    <c:if test="${readOnly!='true'}">
                        <html:file property="newSubAwardAmountInfo.newFile"  />
                    </c:if>
                </td>
            </tr>
            <tr>
            <td  colspan="6" class="infoline">
                <div align="center">
                    <c:if test="${readOnly!='true'}">
                        <html:image property="methodToCall.addAmountInfo.anchor${tabKey}"
                                    src='${ConfigProperties.kra.externalizable.images.url}tinybutton-add1.gif'
                                    styleClass="tinybutton"/>
                    </c:if>
                </div>
            </td>
            </tr>
   			</c:if>
   			</tbody>
   			<c:forEach var="amountInfo" items="${KualiForm.document.subAwardList[0].historicalAmountInfos}" varStatus="status">
					<kra-sub:subAwardAmountInfoLine amountInfo="${amountInfo}" 
						amountInfoPath="document.subAwardList[0].historicalAmountInfos[${status.index}]" 
						index="${status.index}" rowIndex="${status.index}" readOnly="true" currentTabIndex="${currentTabIndex }" formAction="${action}"/>
        	</c:forEach>
        	<c:set var="historicalLength" value="${fn:length(KualiForm.document.subAwardList[0].historicalAmountInfos)}" />
        	<c:forEach var="amountInfo" items="${KualiForm.document.subAwardList[0].subAwardAmountInfoList}" varStatus="status">
					<kra-sub:subAwardAmountInfoLine amountInfo="${amountInfo}" 
						amountInfoPath="document.subAwardList[0].subAwardAmountInfoList[${status.index}]" 
						index="${status.index}" rowIndex="${historicalLength + status.index}" 
						readOnly="${readOnly}" currentTabIndex="${currentTabIndex }" formAction="${action}"/>
        	</c:forEach>
        </table>
    </div>
</kul:tab>
