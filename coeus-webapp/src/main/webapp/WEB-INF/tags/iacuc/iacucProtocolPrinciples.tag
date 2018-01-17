<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="protocolPrinciples" required="true" type="java.util.Map" %>

<c:set var="modifyPermissions" value="${KualiForm.iacucAlternateSearchHelper.modifyPermissions}" />
<c:set var="readOnly" value="${!modifyPermissions}" />

<kul:tabTop tabTitle="The Three R's" defaultOpen="true" tabErrorKey="">
    <div class="tab-container" align="center">
        <h3>
            <span class="subhead-left">Principles</span>
            <span class="subhead-right">
                <kul:help parameterNamespace="KC-IACUC" parameterDetailType="Document" parameterName="iacucProtocolThreeRsPrinciplesHelp" altText="help"/>                
            </span>
        </h3>
        <table cellpadding="4" cellspacing="0" summary="">
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${protocolPrinciples.reduction}" /></div></th>
                <td width="50%" align="left" valign="center">
                    <kul:htmlControlAttribute property="document.protocolList[0].iacucPrinciples[0].reduction" readOnly="${readOnly}" attributeEntry="${protocolPrinciples.reduction}" />
                </td>        
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${protocolPrinciples.refinement}" /></div></th>
                <td width="50%" align="left" valign="center">
                    <kul:htmlControlAttribute property="document.protocolList[0].iacucPrinciples[0].refinement" readOnly="${readOnly}" attributeEntry="${protocolPrinciples.refinement}" />
                </td>        
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${protocolPrinciples.replacement}" /></div></th>
                <td width="50%" align="left" valign="center">
                    <kul:htmlControlAttribute property="document.protocolList[0].iacucPrinciples[0].replacement" readOnly="${readOnly}" attributeEntry="${protocolPrinciples.replacement}" />
                </td>        
            </tr>                        
        </table>
    </div> 
</kul:tabTop>        
