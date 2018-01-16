<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="disclosureAttributes" value="${DataDictionary.CoiDisclosure.attributes}" />
<c:set var="readOnly" value="${KualiForm.document.viewOnly}" />

	<div class="tab-container" align="center">
		<h3> 
			<span class="subhead-left">Review Status</span>
            <span class="subhead-right"><kul:help parameterNamespace="KC-COIDISCLOSURE" parameterDetailType="Document" parameterName="coiAdministratorActionHelp" altText="help"/></span>
 		</h3>
        <table class="tab" cellpadding="0" cellspacing="0" summary=""> 
            <tbody>
                <tr>               
					<th style="width: 150px">
                		<div align="right">
                			<kul:htmlAttributeLabel attributeEntry="${disclosureAttributes.reviewStatusCode}" /></div>       
                		</div>
                	</th>
                	<td style="width: 150px">
                        <kul:htmlControlAttribute property="disclosureActionHelper.coiDisclosure.reviewStatusCode" 
                                                  attributeEntry="${disclosureAttributes.reviewStatusCode}" readOnly="${readOnly}"/>
                	</td>
	            </tr>               
                <tr>
					<td align="center" colspan="4">
						<div align="center">
							<c:if test="${!readOnly}">
							<html:image property="methodToCall.updateDisclosureReviewStatus.anchor${tabKey}"
							            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-submit.gif' styleClass="tinybutton"/>
							</c:if>
						</div>
	                </td>
                </tr>
            </tbody>
        </table>
   </div>
