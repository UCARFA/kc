<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>


<td class="content" valign="top">
<%--
      <channel:messageOfTheDay />
--%>
      <channel:administrationDepartmental />
      <channel:administrationProposals />
      <channel:administrationAwards />
</td>
<td class="content" valign="top">
<%--
      <channel:feedbackChannel />
--%>
      <channel:administrationConflictOfInterest />
      <channel:administrationOther />
</td>

<td class="content" valign="top">
      <channel:administrationNervousSystem />
      <channel:administrationInstitutionalReviewBoard />
</td>
