<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="attributes" value="${DataDictionary.UndoLastActionBean.attributes}" />
<c:set var="action" value="protocolProtocolActions" />
                                    
<kra:permission value="${KualiForm.actionHelper.canUndoLastAction}">

<kul:innerTab tabTitle="Undo Last Action" parentTab="" defaultOpen="false" tabErrorKey="actionHelper.undoLastActionBean.*">
   <kra-irb-action:padLeft>
        <table class="tab" cellpadding="0" cellspacing="0" summary="">
            <tbody>
                <tr>
                    <th width="30%"> 
                        <div align="right">
                            <kul:htmlAttributeLabel attributeEntry="${attributes.comments}" />
                        </div>
                    </th>
                    <td>
                        <nobr>
                        <kul:htmlControlAttribute property="actionHelper.undoLastActionBean.comments" attributeEntry="${attributes.comments}" />
                        </nobr>
                    </td>
                </tr>
                 <tr>
					<td align="center" colspan="2">
						<div align="center">
							<html:image property="methodToCall.undoLastAction.anchor${tabKey}"
							            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-submit.gif' styleClass="tinybutton"/>
						</div>
	                </td>
                </tr>
            </tbody>
        </table>
   </kra-irb-action:padLeft>
    
</kul:innerTab>

</kra:permission>
