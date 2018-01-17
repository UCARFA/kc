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
<c:set var="className"
	value="org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument" />
<kul:tab tabTitle="Custom Data Information" defaultOpen="false" transparentBackground="${transparentBackground }"
	tabErrorKey="">
	<div class="tab-container" align="center">
		<h3>
			<span class="subhead-left">Custom Data Information</span>
		</h3>
		<table cellpadding=0 cellspacing="0" summary="">
			<c:forEach items="${KualiForm.document.customAttributeDocuments}"
				var="customAttributeDocument1" varStatus="status">
				<tr>
					<c:set var="customAttributeLabel"
						value="${customAttributeDocument1.value.customAttribute.label}" />
					<c:set var="customAttributeValue"
						value="${customAttributeDocument1.value.customAttribute.value}" />
					<th width="50%"><div align="left">
							<c:out value="${customAttributeLabel}" />
						</div>
					</th>
					<td><div align=center>
							<c:out value="${customAttributeValue}" />
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</kul:tab>


