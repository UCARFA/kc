<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<tr><td colspan="3">
<div align="center" style="padding: 20px">
<table cellspacing="0" cellpadding="0" border="0" style="width: auto; border-top: 1px solid rgb(153, 153, 153);">
    <tr>
        <td>
                <div align="left" style="font-weight:bold;">
                   Correspondence Type:
                </div>
                <kul:htmlControlAttribute property="batchCorrespondence.batchCorrespondenceTypeCode"
                                          attributeEntry="${DataDictionary.BatchCorrespondenceDetail.attributes.batchCorrespondenceTypeCode}" 
                                          readOnly="false" />          
        </td>
    </tr>
    <tr>
        <td colspan="2" class="infoline nobord" style="padding:4px">
            <div align="center">
            <html:image property="methodToCall.start" 
                 src="${ConfigProperties.kra.externalizable.images.url}tinybutton-refresh.gif" 
                 title="refresh" 
                 alt="refresh" 
                 styleClass="tinybutton"/>
            </div>
        </td>
    </tr>
</table>
</div>
</td></tr>
