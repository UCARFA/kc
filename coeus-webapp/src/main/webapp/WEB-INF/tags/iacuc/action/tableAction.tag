<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="attributes" value="${DataDictionary.IacucProtocolTableBean.attributes}" />
<c:set var="action" value="protocolProtocolActions" />

<kra:permission value="${KualiForm.actionHelper.canTable}">

<kul:innerTab tabTitle="Table Protocol" parentTab="" defaultOpen="false" tabErrorKey="actionHelper.iacucProtocolTableBean*">
   <kra-protocol-action:padLeft>
        <table class="tab" cellpadding="0" cellspacing="0" summary=""> 
          <tbody>
	            <tr>
	            	<th> 
	                    <div align="right">
	                        <kul:htmlAttributeLabel attributeEntry="${attributes.comments}" />
	                    </div>
	                </th>
	                <td>
	                	<kul:htmlControlAttribute property="actionHelper.iacucProtocolTableBean.comments" 
			                                      attributeEntry="${attributes.comments}"/>
	                </td>
	            </tr>
	            
	            <tr>
                    <th> 
                        <div align="right">
                            <nobr>
                                <kul:htmlAttributeLabel attributeEntry="${attributes.actionDate}" />
                            </nobr>
                        </div>
                    </th>
                    <td>
                        <nobr>
                            <kul:htmlControlAttribute property="actionHelper.iacucProtocolTableBean.actionDate" 
                            						  attributeEntry="${attributes.actionDate}"  />
                        </nobr>
                    </td>
                </tr>
	            
	             <tr>
					<td align="center" colspan="2">
						<div align="center">
							<html:image property="methodToCall.tableProtocol.anchor${tabKey}"
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
