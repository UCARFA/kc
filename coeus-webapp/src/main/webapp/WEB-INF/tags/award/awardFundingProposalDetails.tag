<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/award/awardTldHeader.jsp" %>

<%@ attribute name="fundingProposal" required="true" type="org.kuali.kra.award.home.fundingproposal.AwardFundingProposal" %>

<c:set var="activityTypeAttributes" value="${DataDictionary.ActivityType.attributes}" />
<c:set var="fundingProposalAttributes" value="${DataDictionary.InstitutionalProposal.attributes}" />
<c:set var="proposalTypeAttributes" value="${DataDictionary.ProposalType.attributes}" />

<div class="innerTab-head" style="margin-left:60px;" >
	<span class="subhead-left">Proposal Details</span>
	<span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.institutionalproposal.home.InstitutionalProposal" altText="help"/></span>								
</div>
<div style="margin-left:60px;" >
	<table border="0" cellpadding="5" cellspacing="0">
		<tr>
			<th class="infoline" width="15%">
				<div align="right"><kul:htmlAttributeLabel attributeEntry="${fundingProposalAttributes.proposalNumber}" skipHelpUrl="true" /></div>										
				</th>
				<td>
					<c:out value="${fundingProposal.proposal.proposalNumber}" />
				</td>
		</tr>							
		<tr>
			<th class="infoline">
				<div align="right"><kul:htmlAttributeLabel attributeEntry="${fundingProposalAttributes.sequenceNumber}"  skipHelpUrl="true" /></div>										
 				</th>
 				<td>
 					<c:out value="${fundingProposal.proposal.sequenceNumber}" />
 				</td>
		</tr>
		<tr>
			<th class="infoline">
				<div align="right">Proposal Type:</div>										
 				</th>
 				<td>
 					<c:set var="proposalType" value="${fundingProposal.proposal.proposalType}" />
 					<c:if test="${proposalType == null}">
 						<c:set var="proposalType" value="${fundingProposal.proposal.proposalTypeFromCode}" />
 					</c:if>
 					<c:out value="${fundingProposal.proposal.proposalType.description }"/>							  
 				</td>
		</tr>
		<tr>
			<th class="infoline">
				<div align="right">Activity Type:</div>										
 				</th>
 				<td>
 					<c:set var="proposalType" value="${fundingProposal.proposal.activityType}" />
 					<c:if test="${proposalType == null}">
 						<c:set var="proposalType" value="${fundingProposal.proposal.activityTypeFromCode}" />
 					</c:if>
 					<c:out value="${fundingProposal.proposal.activityType.description }" />
 				</td>
		</tr>
		<tr>
			<th class="infoline">
				<div align="right">Proposal Title:</div>										
 				</th>
 				<td>
 					<c:out value="${fundingProposal.proposal.title }"/>
 				</td>
		</tr>
	</table>
</div>
