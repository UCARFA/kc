<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="disclProject" required="true" type="org.kuali.kra.coi.CoiDisclProject" %>
                  
<table class=tab cellpadding="0" cellspacing="0" summary="">
	<tbody>
		<tr>
			<th><div align="right">Proposal Name:</div></th> 
			<td align="left" valign="middle" colspan="3"><div align="left">
				${disclProject.institutionalProposal.title}
			</div></td>
			<th><div align="right">Sponsor:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.institutionalProposal.sponsor.sponsorName}
			</div></td>
		</tr>
		<tr>
			<th><div align="right">Start Date:</div></th> 
			<td align="left" valign="middle"><div align="left">
				<c:choose>
		    	    <c:when test="${disclProject.institutionalProposal.requestedStartDateInitial == null}">
		    	        None
		    	    </c:when>
		    	    <c:otherwise>
		                ${disclProject.institutionalProposal.requestedStartDateInitial}
		            </c:otherwise>
		        </c:choose>
			</div></td>
			<th><div align="right">End Date:</div></th> 
			<td align="left" valign="middle"><div align="left">
				<c:choose>
		    	    <c:when test="${disclProject.institutionalProposal.requestedEndDateInitial == null}">
		    	        None
		    	    </c:when>
		    	    <c:otherwise>
		                ${disclProject.institutionalProposal.requestedEndDateInitial}
		            </c:otherwise>
		        </c:choose>
			</div></td>
			<th><div align="right">PI Name:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.institutionalProposal.principalInvestigator.fullName}
			</div></td>
		</tr>
	</tbody>
</table>
    
