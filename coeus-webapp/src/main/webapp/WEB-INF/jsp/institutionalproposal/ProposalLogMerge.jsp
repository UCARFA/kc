<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<html:hidden name="KualiForm" property="proposalLogNumber" />

Institutional Proposal number to merge:
<html:text name="KualiForm" property="institutionalProposalNumber" />

<div align="center">
<html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_submit.gif" styleClass="globalbuttons" property="methodToCall.mergeToInstitutionalProposal" title="merge" alt="merge"/>
</div>
<kul:csrf />
