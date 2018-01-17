<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="Reports" />
<div class="body">
	<strong>Award Reports</strong>

	<ul class="chan">
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=Active_Awards">Active Awards</a></li>
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=AwardsByPI">Awards by PI</a></li>
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=AwardsBySponsor">Awards by Sponsor</a></li>
 		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=Awards_By_Sponsor_Type">Awards by Sponsor Type</a></li>
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=AwardsByAwardType">Awards by Award Type</a></li>
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=AWARDS_BY_START_DATE">Awards by Notice Date</a></li>
	</ul>

	<strong>Proposal Reports</strong>
	<ul class="chan">
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=ProposalsBySponsor">Institutional Proposals by Sponsor</a></li>
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=ProposalbyProposaType">Institutional Proposals by Proposal Type</a></li>
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=InvestigatorHistory">Investigator Proposal History</a></li>
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=FundingStatus">Funding Status</a></li>
  		<li><a class="portal_link" target="reportWindow" href="${ConfigProperties.application.url}/displayExternalReport.do?awardId=PendingProposals">Institutional Proposals By Lead Unit</a></li>
	</ul>

</div>
<channel:portalChannelBottom />
