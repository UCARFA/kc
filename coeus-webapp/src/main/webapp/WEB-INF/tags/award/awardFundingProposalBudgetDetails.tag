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
	<span class="subhead-left">Budget Details</span>
	<span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.institutionalproposal.home.InstitutionalProposal" altText="help"/></span>								
</div class="innerTab-head">

<div style="margin-left:60px;" >
	<table border="0" cellpadding="5" cellspacing="0">
		<tr>
			<th width="15%">&nbsp;</th>
			<th width="25%">Initial</th>
			<th width="25%">Total</th>
			<th width="35%">&nbsp;</th>
		</tr>
		<tr>
			<th class="infoline">
				<div align="right">Proposed Start Date:</div>										
			</th>
			<td>
				<div align="right">
					<fmt:formatDate value="${fundingProposal.proposal.requestedStartDateInitial }" pattern="MM/dd/yyyy"/>
				</div>
			</td>
			<td>
				<div align="right">
					<fmt:formatDate value="${fundingProposal.proposal.requestedStartDateTotal }" pattern="MM/dd/yyyy"/>
				</div>
			</td>
			<td>&nbsp;</td>
		</tr>							
		<tr>
			<th class="infoline">
				<div align="right">Proposed End Date:</div>										
			</th>
			<td>
				<div align="right">
					<fmt:formatDate value="${fundingProposal.proposal.requestedEndDateInitial }" pattern="MM/dd/yyyy"/>
				</div>
			</td>
			<td>
				<div align="right">
					<fmt:formatDate value="${fundingProposal.proposal.requestedEndDateTotal }" pattern="MM/dd/yyyy"/>
				</div>
			</td>
 			<td>&nbsp;</td>
		</tr>
		<tr>
			<th class="infoline">
				<div align="right">Proposed Direct Cost:</div>										
			</th>
			<td>
				<div align="right">
					<fmt:formatNumber value="${fundingProposal.proposal.totalDirectCostInitial }" type="currency" currencySymbol="$" maxFractionDigits="2"/>
				</div>
			</td>
			<td>
				<div align="right">
					<fmt:formatNumber value="${fundingProposal.proposal.totalDirectCostTotal }" type="currency" currencySymbol="$" maxFractionDigits="2"/>
				</div>
			</td>
 			<td>&nbsp;</td>
		</tr>
		<tr>
			<th class="infoline">
				<div align="right">Proposed F&amp;A Cost:</div>										
			</th>
			<td>
				<div align="right">
					<fmt:formatNumber value="${fundingProposal.proposal.totalIndirectCostInitial }" type="currency" currencySymbol="$" maxFractionDigits="2"/>
				</div>
			</td>
			<td>
				<div align="right">
					<fmt:formatNumber value="${fundingProposal.proposal.totalIndirectCostTotal }" type="currency" currencySymbol="$" maxFractionDigits="2"/>
				</div>
			</td>
 			<td>&nbsp;</td>
		</tr>
		<tr>
			<th class="infoline">
				<div align="right">Proposed Total Cost:</div>										
			</th>
			<td>
				<div align="right">
					<strong><fmt:formatNumber value="${fundingProposal.proposal.totalInitialCost }" type="currency" currencySymbol="$" maxFractionDigits="2"/></strong>
				</div>
			</td>
			<td>
				<div align="right">
					<strong><fmt:formatNumber value="${fundingProposal.proposal.totalCost }" type="currency" currencySymbol="$" maxFractionDigits="2"/></strong>
				</div>
			</td>
 			<td>&nbsp;</td>
		</tr>
	</table>
</div>
