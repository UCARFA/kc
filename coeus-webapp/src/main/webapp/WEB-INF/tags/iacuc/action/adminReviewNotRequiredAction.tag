<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="attributes" value="${DataDictionary.ProtocolReviewNotRequiredBean.attributes}" />  
<c:set var="action" value="protocolProtocolActions" />

<kra:permission value="${KualiForm.actionHelper.canReviewNotRequired}">
	<tr>
		<td class="tab-subhead" scope="row">
			<kul:innerTab tabTitle="Review Not Required" parentTab="" defaultOpen="false" tabErrorKey="actionHelper.protocolReviewNotRequired*" overrideDivClass="inner-subhead" >
			    <div class="innerTab-container" align="left">
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
			                        <kul:htmlControlAttribute property="actionHelper.protocolReviewNotRequiredBean.comments" attributeEntry="${attributes.comments}" />
			                        </nobr>
			                    </td>
			                </tr>
			                <tr>
								<td align="center" colspan="2">
									<div align="center">
										<html:image property="methodToCall.protocolReviewNotRequired.anchor${tabKey}"
										            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-submit.gif' styleClass="tinybutton"/>
									</div>
				                </td>
			                </tr>
			            </tbody>
			        </table>
			    </div>	    
			</kul:innerTab>
		</td>
	</tr>
</kra:permission>
