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
				${disclProject.proposal.title}
			</div></td>
			<th><div align="right">Sponsor:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.proposal.sponsor.sponsorName}
			</div></td>
		</tr>
		<tr>
			<th><div align="right">start Date:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.proposal.requestedStartDateInitial}
			</div></td>
			<th><div align="right">End Date:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.proposal.requestedEndDateInitial}
			</div></td>
			<th><div align="right">PI Name:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.proposal.principalInvestigatorName}
			</div></td>
		</tr>
	</tbody>
</table>
