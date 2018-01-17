<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="tabTitle" required="true" %>
<%@ attribute name="bean" required="true" type="org.kuali.kra.iacuc.actions.genericactions.IacucProtocolGenericActionBean" %>
<%@ attribute name="property" required="true" %>
<%@ attribute name="taskName" required="true" %>
<%@ attribute name="methodToCall" required="true" %>
<%@ attribute name="canPerformAction" required="false" %>
<%@ attribute name="canAddReviewComments" required="false" %>
<%@ attribute name="defaultOpen" required="false" %>

<c:if test="${empty canPerformAction}">
    <c:set var="canPerformAction" value="true" />
</c:if>

<c:if test="${empty canAddReviewComments}">
    <c:set var="canAddReviewComments" value="true" />
</c:if>

<c:if test="${empty defaultOpen}">
    <c:set var="defaultOpen" value="false" />
</c:if>

<c:set var="attributes" value="${DataDictionary.IacucProtocolGenericActionBean.attributes}" />
<c:set var="action" value="protocolProtocolActions" />

<kra:permission value="${canPerformAction}">

<kul:innerTab tabTitle="${tabTitle}" parentTab="" defaultOpen="${defaultOpen}" tabErrorKey="${property}.*">
   
   <kra-protocol-action:padLeft>
        <table class="tab" cellpadding="0" cellspacing="0" summary=""> 
            <tbody>
                
                <tr>
                    <th width="15%"> 
                        <div align="right">
                            <nobr>
                                <kul:htmlAttributeLabel attributeEntry="${attributes.comments}" />
                            </nobr>
                        </div>
                    </th>
                    <td>
                        <nobr>
                            <kul:htmlControlAttribute property="${property}.comments" 
                                                      attributeEntry="${attributes.comments}" />
                        </nobr>
                    </td>
                </tr>
                
                <tr>
                    <th width="15%"> 
                        <div align="right">
                            <nobr>
                                <kul:htmlAttributeLabel attributeEntry="${attributes.actionDate}" />
                            </nobr>
                        </div>
                    </th>
                    <td>
                        <nobr>
                            <kul:htmlControlAttribute property="${property}.actionDate" 
                                                      attributeEntry="${attributes.actionDate}"  />
                        </nobr>
                    </td>
                </tr>
                
                <c:if test="${canAddReviewComments}">
	                <tr>
	                    <td colspan="2">
	                        <kra-iacuc-action:reviewComments bean="${bean.reviewCommentsBean}"
	                                                       property="${property}.reviewCommentsBean"
	                                                       action="${action}"
	                                                       taskName="${taskName}" />
	                   </td>
	                </tr>
	            </c:if>
                
                <tr>
                    <td align="center" colspan="2">
                        <div align="center">
                            <html:image property="methodToCall.${methodToCall}.anchor${tabKey}"
                                        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-submit.gif' 
                                        styleClass="tinybutton"/>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>       
   </kra-protocol-action:padLeft>
    
</kul:innerTab>

</kra:permission>
