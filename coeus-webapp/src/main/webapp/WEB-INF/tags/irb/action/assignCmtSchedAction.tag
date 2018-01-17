<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="attributes" value="${DataDictionary.ProtocolAssignCmtSchedBean.attributes}" />
<c:set var="action" value="protocolProtocolActions" />

<kra:permission value="${KualiForm.actionHelper.canAssignCmtSched}">

<kul:innerTab tabTitle="Assign to Committee and Schedule" parentTab="" defaultOpen="false" tabErrorKey="actionHelper.assignCmtSchedBean*">
    <div class="innerTab-container" align="left">
        <table class="tab" cellpadding="0" cellspacing="0" summary=""> 
            <tbody>
                <tr>
	                <th style="width: 300px"> 
	                    <div align="right">
	                        <kul:htmlAttributeLabel attributeEntry="${attributes.committeeId}" />
	                    </div>
	                </th>
	                <td style="width : 150px">
                        	                
	                    <c:set var="docNumber" value="${KualiForm.document.protocol.protocolNumber}" />
                        <html:select property="actionHelper.assignCmtSchedBean.committeeId" onchange="onlyLoadScheduleDates('actionHelper.assignCmtSchedBean.committeeId', '${docNumber}', 'actionHelper.assignCmtSchedBean.scheduleId');" >                               
                            <c:forEach items="${KualiForm.actionHelper.assignCmtSchedActionCommitteeIdByUnitKeyValues}" var="option" >
                                <c:choose>                      
                                    <c:when test="${KualiForm.actionHelper.assignCmtSchedBean.committeeId == option.key}">
                                        <option value="${option.key}" selected="selected">${option.value}</option>
                                    </c:when>
                                    <c:otherwise>                               
                                        <c:out value="${option.value}"/>
                                        <option value="${option.key}">${option.value}</option>
                                    </c:otherwise>
                                </c:choose>                                                
                            </c:forEach>
                        </html:select>
	                </td>
	               
		            <th style="width: 150px"> 
		                <div align="right"><nobr>
		                    <kul:htmlAttributeLabel attributeEntry="${attributes.scheduleId}" /></nobr>
		                </div>
		            </th>
		            <td>
		               <nobr>
				           <kul:htmlControlAttribute property="actionHelper.assignCmtSchedBean.scheduleId" 
				                                         attributeEntry="${attributes.scheduleId}" />
				            <noscript>
                            <html:image property="methodToCall.refreshPage.anchor${tabKey}"
                                        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-refresh.gif' styleClass="tinybutton"/>
                            </noscript>
		               </nobr>
		            </td>
	            </tr>
                
                <tr>
					<td align="center" colspan="4">
						<div align="center">
							<html:image property="methodToCall.assignCommitteeSchedule.anchor${tabKey}"
							            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-submit.gif' styleClass="tinybutton"/>
						</div>
	                </td>
                </tr>
            </tbody>
        </table>
    </div>
    
</kul:innerTab>

</kra:permission>
