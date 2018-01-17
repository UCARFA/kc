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
			<th><div align="right">IRB Protocol Name:</div></th> 
			<td align="left" valign="middle" colspan="3"><div align="left">
				${disclProject.protocol.title}
			</div></td>
			<th><div align="right">IRB Protocol Type:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.protocol.protocolType.description}
			</div></td>
		</tr>
		<tr>
			<th><div align="right">Application Date:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.protocol.applicationDate}
			</div></td>
			<th><div align="right">Expiration Date:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.protocol.expirationDate}
			</div></td>
			<th><div align="right">PI Name:</div></th> 
			<td align="left" valign="middle"><div align="left">
				${disclProject.protocol.principalInvestigatorName} 
			</div></td>
		</tr>
	</tbody>
</table>
