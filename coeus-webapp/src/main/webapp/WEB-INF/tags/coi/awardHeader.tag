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
      <th><div align="right">Title:</div></th> 
      <td align="left" valign="middle"><div align="left">
		${disclProject.award.title}
	  </div></td>
      <th><div align="right">Award Date:</div></th> 
      <td align="left" valign="middle"><div align="left">
		${disclProject.award.awardEffectiveDate}
	  </div></td>
	 </tr>
	</tbody>
</table>
