<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="amendmentSummaries" value="${KualiForm.actionHelper.amendmentSummaries}"  />
<c:if test="${fn:length(amendmentSummaries) > 0}">

<kul:innerTab tabTitle="Amendment/Renewal History" parentTab="" defaultOpen="false" tabErrorKey="">

    <div class="innerTab-container" align="left">
	    <h3>
   			<span class="subhead-left">Amendments/Renewals</span>
		</h3>
        <table id="amendHistoryTable" class="tab" cellpadding="0" cellspacing="0" summary="">
            <tbody>
                <tr>
	                <th style="width:10%;">Type</th>
	                <th style="width:5%;">Version Number</th>
	                <th style="width:60%;">Summary</th>
	                <th style="width:15%;">Status</th>
	                <th style="width:10%;">Created Date</th>
                </tr>
                <c:forEach items="${amendmentSummaries}" var="protocolSummary" varStatus="status">
            		<tr>
            		    <td>
            		        <nobr><u><a href="${protocolSummary.versionNumberUrl}" target="_blank" alt="Open this version in a separate tab">${protocolSummary.amendmentType}</a></u></nobr>
            		    </th>
            		    <td>
            		        <nobr><u><a href="${protocolSummary.versionNumberUrl}" target="_blank" alt="Open this version in a separate tab">${protocolSummary.versionNumber}</a></u></nobr>
            		    </td>
            		    <td>
							${protocolSummary.description}
            		    </td>
            		    <td>
            		        <nobr>${protocolSummary.status}</nobr>
            		    </td>
            		    <td>
            		        <nobr>${protocolSummary.createDate}</nobr>
            		    </td>
            		</tr>
					<c:set var="protocolNumber" value="${amendmentSummaries[status.index].amendRenewProtocol.protocolNumber}" />
           			<tr>
           				<td>&nbsp;</td>
           			    <td class="infoline" colspan="5">
							<c:set var="questionnaireTabTitle" value="${protocolSummary.amendmentType} Questionnaires - ${protocolNumber}" />
     						<kra-protocol:protocolViewAmendmentHistoryQuestionnaire questionnaireTabTitle = "${questionnaireTabTitle}" answerHeaders="${amendmentSummaries[status.index].answerHeaders}" />
					    </td>
					</tr>        
            	</c:forEach>
            </tbody>
        </table>
    </div>
    			
</kul:innerTab>
</c:if>
