<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="Pre-Award" />

<div class="body" id="portchancont">
  <table border="0" cellpadding="2" cellspacing="0">
   <tr>
    <td nowrap class=""> Proposal Development </td>
    <td>
      <portal:portalLink displayTitle="false" title="Proposal Development" url="proposalDevelopmentProposal.do?methodToCall=docHandler&command=initiate&docTypeName=ProposalDevelopmentDocument"><img src="static/images/add.png" alt="add" width="16" height="16" border="0" align="absmiddle"></portal:portalLink>
      <img src="static/images/searchicon.gif" alt="lookup" width="16" height="16" align="absmiddle">
    </td>
  </tr>
  <tr>
    <td nowrap class="disabled-text">Submitted Proposal</td>
    <td>
      <img src="static/images/add1.png" alt="add" width="16" height="16" border="0" align="absmiddle">
      <img src="static/images/searchicon1.gif" alt="lookup" width="16" height="16" align="absmiddle">
    </td>
  </tr>

  <tr>
    <td nowrap class="disabled-text">Proposal Log</td>
    <td>
      <img src="static/images/add1.png" alt="add" width="16" height="16" border="0" align="absmiddle">
      <img src="static/images/searchicon1.gif" alt="lookup" width="16" height="16" align="absmiddle">
      
    </td>
  </tr>

  <tr>
    <td nowrap class="disabled-text">Negotiations</td>
    <td>
      <img src="static/images/add1.png" alt="add" width="16" height="16" border="0" align="absmiddle">
      <img src="static/images/searchicon1.gif" alt="lookup" width="16" height="16" align="absmiddle">
    </td>
  </tr>
</table>
</div>
<channel:portalChannelBottom />
