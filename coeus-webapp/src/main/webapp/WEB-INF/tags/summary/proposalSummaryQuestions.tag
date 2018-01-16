<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="bean" required="true"
	type="org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireHelperBase"%>
<%@ attribute name="property" required="true"%>
<%@ attribute name="forceNonTransparent" required="false" %>
<%@ attribute name="transparentBackground" required="false" %>
<%@ attribute name="parentTab" required="true" %>

<c:forEach items="${bean.answerHeaders}" var="answerHeader"
	varStatus="status">
	
	<c:set var="readOnly" value="true" scope="request" />

	<c:set var="prop"
		value="${property}.answerHeaders[${status.index}].showQuestions" />
	${kfunc:registerEditableProperty(KualiForm, prop)}
	<input type="hidden" name="${prop}" id="${prop}"
		value="${bean.answerHeaders[status.index].showQuestions}" />

	<kra-questionnaire:questionnaireAnswersInnerTab bean="${bean}" property="${property}" answerHeaderIndex="${status.index}"
		forceNonTransparent="true" readOnly="true" parentTab="${parentTab}"/>
</c:forEach>

<c:if test="${fn:length(bean.answerHeaders) > 0}">

	${kfunc:registerEditableProperty(KualiForm, "numberOfQuestionaires")}
    <input type="hidden" name="numberOfQuestionaires"
		id="numberOfQuestionaires:${property}" class="numberOfQuestionnaires"
		value="${fn:length(bean.answerHeaders)}" />

</c:if>



