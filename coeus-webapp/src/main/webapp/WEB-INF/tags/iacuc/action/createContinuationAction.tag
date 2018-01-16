<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="action" value="protocolProtocolActions" />
<c:set var="attributes" value="${DataDictionary.IacucProtocolAmendmentBean.attributes}" />

<kra:permission value="${KualiForm.actionHelper.canCreateContinuation}">

<kul:innerTab tabTitle="Create Continuation without Amendment" parentTab="" defaultOpen="false" tabErrorKey="actionHelper.protocolContinuation*,actionHelper.continuationSummary">
    <div class="innerTab-container" align="left">
        <table class="tab" cellpadding="0" cellspacing="0" summary="">
            <tbody>
                 <tr>
                    <th width="15%"> 
                        <div align="right">
                            <nobr>
                            * Summary:
                            </nobr>
                        </div>
                    </th>
                    <td>
                        <nobr>
                        <kul:htmlControlAttribute property="actionHelper.continuationSummary" attributeEntry="${attributes.summary}" />
                        </nobr>
                    </td>
                </tr>
 
                <tr>
					<td align="center" colspan="2">
						<div align="center">
						    <html:image property="methodToCall.createContinuation.anchor${tabKey}"
							        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-create.gif' styleClass="tinybutton"/>
                        </div>
	                </td>
                </tr>
            </tbody>
        </table>
    </div>
    
</kul:innerTab>

</kra:permission>
