<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="attributes" value="${DataDictionary.ProtocolAssignToAgendaBean.attributes}" />
<c:set var="action" value="protocolProtocolActions" />

<kra:permission value="${KualiForm.actionHelper.canAssignToAgenda}">

<kul:innerTab tabTitle="Assign to Agenda" parentTab="" defaultOpen="false" tabErrorKey="actionHelper.assignToAgendaBean*">
   <kra-irb-action:padLeft>
        <table class="tab" cellpadding="0" cellspacing="0" summary=""> 
          <tbody>
	            <tr>
	            	<th> 
	                    <div align="right">
	                        <kul:htmlAttributeLabel attributeEntry="${attributes.committeeId}" />
	                    </div>
	                </th>
	                <td>
	                	<kul:htmlControlAttribute property="actionHelper.assignToAgendaBean.committeeId" 
			                                      attributeEntry="${attributes.committeeId}"
			                                      readOnly="${true}" />
	                </td>
	            </tr>
	            <tr>
	            	<th> 
	                    <div align="right">
	                        <kul:htmlAttributeLabel attributeEntry="${attributes.committeName}" />
	                    </div>
	                </th>
	                <td>
	                	<kul:htmlControlAttribute property="actionHelper.assignToAgendaBean.committeName" 
			                                      attributeEntry="${attributes.committeName}"
			                                      readOnly="${true}" />
	                </td>
	            </tr>
	            <tr>
	            	<th> 
	                    <div align="right">
	                        <kul:htmlAttributeLabel attributeEntry="${attributes.scheduleDate}" />
	                    </div>
	                </th>
	                <td>
	                	
	                	<kul:htmlControlAttribute property="actionHelper.assignToAgendaBean.scheduleDate" 
			                                      attributeEntry="${attributes.scheduleDate}"
			                                      readOnly="${true}" />
	                </td>
	            </tr>
	  
	            <tr>
	            	<th> 
	                    <div align="right">
	                        <kul:htmlAttributeLabel attributeEntry="${attributes.comments}" />
	                    </div>
	                </th>
	                <td>
	                	<kul:htmlControlAttribute property="actionHelper.assignToAgendaBean.comments" 
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
                            <kul:htmlControlAttribute property="actionHelper.assignToAgendaBean.actionDate" 
                            						  attributeEntry="${attributes.actionDate}"  />
                        </nobr>
                    </td>
                </tr>
	            
	            
	            <tr>
                    <td colspan="2">
                        <kra-irb-action:reviewComments bean="${KualiForm.actionHelper.assignToAgendaBean.reviewCommentsBean}"
                                                       property="actionHelper.assignToAgendaBean.reviewCommentsBean"
                                                       action="${action}"
                                                       taskName="protocolAssignToAgenda" />
                   </td>
                </tr>
	            
	             <tr>
					<td align="center" colspan="2">
						<div align="center">
							<html:image property="methodToCall.assignToAgenda.anchor${tabKey}"
							            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-submit.gif' 
							            styleClass="tinybutton"/>
						</div>
	                </td>
                </tr>
	            
            </tbody>
        </table>
   </kra-irb-action:padLeft>
</kul:innerTab>

</kra:permission>
