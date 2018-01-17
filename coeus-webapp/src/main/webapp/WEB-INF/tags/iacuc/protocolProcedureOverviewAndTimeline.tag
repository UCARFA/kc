<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="businessObjectClassName" required="true" 
              description="The specific per-module business class to use for the help pages" %>

<c:set var="protocolDocumentAttributes" value="${DataDictionary.IacucProtocolDocument.attributes}" />
<c:set var="protocolAttributes" value="${DataDictionary.IacucProtocol.attributes}" />

<c:set var="readOnly" value="${!KualiForm.iacucProtocolProceduresHelper.modifyProtocolProcedures}" />


<kul:tab tabTitle="Overview and Timeline" defaultOpen="true" alwaysOpen="true" transparentBackground="true" tabErrorKey="document.protocolList[0].overviewTimeline">
    <div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left">Overview and Timeline</span>
    		<span class="subhead-right"><kul:help parameterNamespace="KC-IACUC" parameterDetailType="Document" parameterName="iacucProtocolOverviewAndTimelineHelp" altText="Help"/></span>
        </h3>
        
        <table id="protocolOverviewTimelineTableId" cellpadding="0" cellspacing="0" summary="">
          	<tr>
          		<th><div align="center"><kul:htmlAttributeLabel attributeEntry="${protocolAttributes.overviewTimeline}" noColon="true" /></div></th>
          	</tr>     

			<%-- 
        	<kra:permission value="${KualiForm.iacucProtocolProceduresHelper.modifyProtocolProcedures}">            
	        </kra:permission>
	        --%>          
                <tr>
	                <c:set var="textAreaFieldName" value="document.protocolList[0].overviewTimeline" />
		            <td align="left" valign="middle" class="infoline">
		               	<div align="center">
		               		<kul:htmlControlAttribute property="document.protocolList[0].overviewTimeline" 
		               		                          attributeEntry="${protocolAttributes.overviewTimeline}" 
		               		                          readOnly="${readOnly}" />
		            	</div>
					</td>
	            </tr>
        </table>
    </div> 
</kul:tab>

