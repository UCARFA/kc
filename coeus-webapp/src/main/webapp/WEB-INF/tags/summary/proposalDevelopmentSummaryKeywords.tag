<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="transparentBackground" required="false" %>
<c:set var="proposalDevelopmentAttributes"
	value="${DataDictionary.DevelopmentProposal.attributes}" />
<c:set var="scienceKeywordAttributes"
	value="${DataDictionary.ScienceKeyword.attributes}" />
<c:set var="textAreaFieldName"
	value="document.developmentProposalList[0].mailDescription" />
<c:set var="action" value="proposalDevelopmentApproverView" />
<c:set var="className"
	value="org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument" />

<kul:tab
	tabTitle="Keywords (${fn:length(KualiForm.document.developmentProposalList[0].propScienceKeywords)})" transparentBackground="${transparentBackground }"
	defaultOpen="false" tabErrorKey="">
	<div class="tab-container" align="center">
		<h3>
			<span class="subhead-left">Keywords</span>
		</h3>

		<table cellpadding=0 cellspacing="0" summary="">
			<tr>
				<th><div align="left"></div>
				</th>
				<th><div align="left">
						<kul:htmlAttributeLabel
							attributeEntry="${scienceKeywordAttributes.description}"
							noColon="true" />
					</div>
				</th>
			</tr>
			<logic:iterate name="KualiForm" id="proposalKeywords"
				property="document.developmentProposalList[0].propScienceKeywords"
				indexId="ctr">
				<tr>
					<td class="infoline"><div align="center">${ctr+1}</div>
					</td>

					<td>
						<div align="left">${KualiForm.document.developmentProposalList[0].propScienceKeywords[ctr].scienceKeyword.description}&nbsp;</div>
					</td>
				</tr>
			</logic:iterate>

		</table>
	</div>
</kul:tab>





