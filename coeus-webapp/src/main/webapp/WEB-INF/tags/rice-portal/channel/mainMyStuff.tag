<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="My Stuff" />
<div class="body">
<strong>Proposals </strong>
<ul class="chan">
  <li>Proposals in Progress</li>
  <li><portal:portalLink displayTitle="false" title='All My Proposals' url='${ConfigProperties.workflow.url}/DocumentSearch.do?methodToCall=doDocSearch&docTypeFullName=ProposalDevelopmentDocument&initiator=quickstart&searchCriteriaEnabled=false'>All My Proposals</portal:portalLink></li>
</ul>

<strong>Negotiations</strong>
<ul class="chan">
  <li>All My Negotiations</li>
</ul>

<strong>Awards</strong>
<ul class="chan">
  <li>Awards in Progress</li>
  <li>All My Awards</li>
</ul>

<strong>IRB Protocols </strong>
<ul class="chan">
  <li>Pending Protocols</li>
  <li>All My Protocols</li>
  <li>Pending PI Action</li>
  <li>Amendments &amp; Renewals</li>
</ul>

<strong>Conflict of Interest Disclosure </strong>
<ul class="chan">
  <li>Review Financial Entities</li>
  <li>Review Disclosures</li>
  <li>View Pending Disclosures</li>
</ul>

<strong>Personnel</strong>
<ul class="chan">
  <li>Degree Information</li>
  <li>Current &amp; Pending Support</li>
  <li>Bio-sketches</li>
</ul>

<strong>My Training</strong>
<ul class="chan">
</ul>
</div>
<channel:portalChannelBottom />
