<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="committeeAttributes" value="${DataDictionary.Committee.attributes}" />
<c:set var="batchCorrespondenceDetailAttributes" value="${DataDictionary.BatchCorrespondenceDetail.attributes}" />
<c:set var="kraAttributeReferenceDummyAttributes" value="${DataDictionary.KraAttributeReferenceDummy.attributes}" />

<h3>
    <span class="subhead-left">Batch Correspondence History</span>
    <span class="subhead-right"><kul:help parameterNamespace="KC-COMMITTEE" parameterDetailType="Document" parameterName="committeeBatchCorrespondenceHistoryHelpUrl" altText="help"/></span>
</h3>

<table cellpadding="0" cellspacing="0">
    <tr>
        <th width="20%">
            <div align="right">
                Committee ID:
            </div>
        </th> 
        <td width="30%">
            <div align="left">
                <kul:htmlControlAttribute property="document.committeeList[0].committeeId" 
                                          attributeEntry="${committeeAttributes.committeeId}" 
                                          readOnly="true" />
            </div>
        </td>
        
        <th width="20%">
            <div align="right">
                Committee Name:
            </div>
        </th> 
        <td width="30%">
            <div align="left">
                <kul:htmlControlAttribute property="document.committeeList[0].committeeName" 
                                          attributeEntry="${committeeAttributes.committeeName}" 
                                          readOnly="true" />
            </div>
        </td>
    </tr> 
    <tr>
        <th>
            <div align="right">
                *Batch Type:
            </div>
        </th> 
        <td>
            <div align="left">
                <kul:htmlControlAttribute property="committeeHelper.historyBatchCorrespondenceTypeCode" 
                                          attributeEntry="${batchCorrespondenceDetailAttributes.batchCorrespondenceTypeCode}" 
                                          readOnly="false" />
            </div>
        </td>
        
        <th>
            <div align="right">
                Run Date:
            </div>
        </th> 
        <td>
            <div align="left">
                from
                <kul:htmlControlAttribute property="committeeHelper.historyStartDate" 
                                          attributeEntry="${kraAttributeReferenceDummyAttributes.genericDate}"
                                          readOnly="false" />
                to
                <kul:htmlControlAttribute property="committeeHelper.historyEndDate" 
                                          attributeEntry="${kraAttributeReferenceDummyAttributes.genericDate}" 
                                          readOnly="false" />
            </div>
        </td>
    </tr>
    <tr>
        <td class="infoline" colspan="4">
            <div align="center">
                <html:image property="methodToCall.filterBatchCorrespondenceHistory"
                            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-filter.gif' 
                            styleClass="tinybutton"/>
            </div>                         
        </td>
    </tr> 
</table>

<c:if test="${not empty KualiForm.committeeHelper.historyBatchCorrespondenceTypeCode}">
    <p>&nbsp;</p>
    
    <div align="left">
        <kul:errors keyMatch="committeeHelper.batchCorrespondenceHistory*" /> <br>
    </div>

    <h3>
        <span class="subhead-left">
            Batch Type:
            <kul:htmlControlAttribute property="committeeHelper.historyBatchCorrespondenceTypeCode" 
                                      attributeEntry="${batchCorrespondenceDetailAttributes.batchCorrespondenceTypeCode}" 
                                      readOnly="true" />
        </span>
        <span class="subhead-right"><kul:help parameterNamespace="KC-COMMITTEE" parameterDetailType="Document" parameterName="committeeBatchCorrespondenceHelpUrl" altText="help"/></span>
    </h3>
    
    <c:if test="${not empty KualiForm.committeeHelper.batchCorrespondenceHistory}">
        <div id="historyDetails">  
    
        <table cellpadding=0 cellspacing=0 border=0>
            <c:forEach items="${krafn:copy(KualiForm.committeeHelper.batchCorrespondenceHistory)}" var="batchCorrespondenceHistory" varStatus="status">
                <tr>
                    <td class="infoline" colspan="2">
                        <kra-committee:committeeActionBatchCorrespondenceRun committeeBatchCorrespondence="${batchCorrespondenceHistory}" committeeBatchCorrespondenceProperty="committeeHelper.batchCorrespondenceHistory[${status.index}]" />
                    </td>
                </tr>
            </c:forEach>
                <tr>
                    <td class="neutral" width = "94%" style="background-color: #e4e4e4;">
                        &nbsp;
                    </td>
                    <td  style="background-color: #e4e4e4;" >
                        <div align="center">
                           <a id= "viewBatchCorrespondenceHistory" href="#"> <html:image property="methodToCall.viewBatchCorrespondenceHistory"
                                        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-view.gif' 
                                        styleClass="tinybutton"
                                        onclick="excludeSubmitRestriction = true;" />
                           </a>
                        </div>                         
                    </td>
                </tr>
        </table>
        </div>
        
    </c:if>            
</c:if>            
