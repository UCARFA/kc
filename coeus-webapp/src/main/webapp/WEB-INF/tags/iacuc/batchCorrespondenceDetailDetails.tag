<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

    <tr>
        <kul:htmlAttributeHeaderCell literalLabel="${KualiForm.batchCorrespondence.daysToEventUiText}" scope="col" align="center" width="30%" />
        <kul:htmlAttributeHeaderCell literalLabel="Take this Action" scope="col" align="center" width="50%" />
        <c:if test="${!readOnly}">
            <kul:htmlAttributeHeaderCell literalLabel="Actions" scope="col" align="center" width="20%" />
        </c:if>
    </tr>
    
    <%-- New Details --%>
    <c:if test="${!readOnly}">
    	<tbody class="addline">
        <tr>
            <td class="infoline nobord">
                <div align="center" style="font-weight:bold;">
                    <kul:htmlControlAttribute property="newBatchCorrespondenceDetail.daysToEvent"
                                              attributeEntry="${DataDictionary.IacucBatchCorrespondenceDetail.attributes.daysToEvent}" />
                </div>
            </td>
            <td class="infoline nobord">
                <div align="left">
                    <kul:htmlControlAttribute property="newBatchCorrespondenceDetail.protoCorrespTypeCode"
                                              attributeEntry="${DataDictionary.IacucBatchCorrespondenceDetail.attributes.protoCorrespTypeCode}" />
                </div>
            </td>
            <td class="infoline nobord">
                <div align="center">
                <html:image property="methodToCall.addBatchCorrespondenceDetail" 
                    src="${ConfigProperties.kra.externalizable.images.url}tinybutton-add1.gif" 
                    title="Add Correspondence Template" 
                    alt="Add Correspondence Template" 
                    styleClass="tinybutton addButton" />
                </div>
            </td>
        </tr>
        </tbody>
    </c:if>
    <%-- New Details --%>
    
    <%-- Existing Details --%> 
    <c:forEach items="${KualiForm.batchCorrespondence.batchCorrespondenceDetails}" var="details" varStatus="status">
        <tr>
            <td>
                <div align="center">
                   ${details.daysToEvent}
                </div>
            </td>
            <td>
                <div align="left">
                    ${details.protocolCorrespondenceType.description}
                </div>
            </td>
            <c:if test="${!readOnly}">
                <td>
                    <div align="center">
                        <html:image property="methodToCall.deleteBatchCorrespondenceDetail.batchCorrespondenceDetail[${status.index}]}" 
                            src="${ConfigProperties.kra.externalizable.images.url}tinybutton-delete1.gif" 
                            title="delete" 
                            alt="delete" 
                            styleClass="tinybutton" />
                    </div>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    <%-- Existing Details --%>
    
    <%-- Final IACUC Notification Action --%>
    <tr>
        <td>
            <c:if test="${KualiForm.batchCorrespondence.sendCorrespondence == 'BEFORE'}">
                <div align="center" style="font-weight:bold;">
                    0
                </div>
            </c:if>
            <c:if test="${KualiForm.batchCorrespondence.sendCorrespondence == 'AFTER'}">
                <div align="center" style="font-weight:bold;">
                        <kul:htmlControlAttribute property="batchCorrespondence.finalActionDay"
                                                  attributeEntry="${DataDictionary.IacucBatchCorrespondence.attributes.finalActionDay}" />          
                </div>
            </c:if>
        </td>
        <td>
            <div align="left">
                <kul:htmlControlAttribute property="batchCorrespondence.finalActionCorrespType"
                                          attributeEntry="${DataDictionary.IacucBatchCorrespondence.attributes.finalActionCorrespType}"
                                          readOnlyAlternateDisplay="${KualiForm.batchCorrespondence.protocolCorrespondenceType.description}" />
                <c:if test="${readOnly && not empty KualiForm.batchCorrespondence.finalActionCorrespType && not empty KualiForm.batchCorrespondence.finalActionTypeCode}">
                    &nbsp; | &nbsp;  
                </c:if>
                <kul:htmlControlAttribute property="batchCorrespondence.finalActionTypeCode"
                                          attributeEntry="${DataDictionary.IacucBatchCorrespondence.attributes.finalActionTypeCode}" 
                                          readOnlyAlternateDisplay="${KualiForm.batchCorrespondence.protocolActionType.description}" />
            </div>
        </td>
        <c:if test="${!readOnly}">
            <td>
            </td>
        </c:if>
    </tr>
    <%-- Final --%>    
