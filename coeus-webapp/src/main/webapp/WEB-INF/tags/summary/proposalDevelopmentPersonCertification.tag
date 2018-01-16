<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/kr/WEB-INF/jsp/tldHeader.jsp"%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="answerHeaderIndex" value="0" /> 
<c:set var="property" value="proposalPersonQuestionnaireHelpers[${personIndex}]" />
<c:set var="bean" value="${KualiForm.proposalPersonQuestionnaireHelpers[personIndex]}" />

<kra-questionnaire:questionnaireAnswers bean="${bean}"
	property="${property}" answerHeaderIndex="${answerHeaderIndex}" readOnly="true" defaultOpen="true"/>










