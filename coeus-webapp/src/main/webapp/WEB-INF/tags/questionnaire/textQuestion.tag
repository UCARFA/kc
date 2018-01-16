<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="question" required="true" type="org.kuali.coeus.common.questionnaire.framework.question.Question" %>
<%@ attribute name="answer" required="true" type="org.kuali.coeus.common.questionnaire.framework.answer.Answer" %>
<%@ attribute name="questionIndex" required="true" %>

<%@ attribute name="answerHeaderIndex" required="true" %>
<%@ attribute name="bean" required="true" type="org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireHelperBase" %>
<%@ attribute name="property" required="true" %>
<%@ attribute name="answerValidationError" required = "true" %>

<c:set var="questionFieldName" value="${property}.answerHeaders[${answerHeaderIndex}].answers[${questionIndex}].answer" />
${kfunc:registerEditableProperty(KualiForm, questionFieldName)}

<c:set var="answerLength" value="${question.answerMaxLength}" />
<c:choose>
	<c:when test="${answerLength > 300}">
		<html:textarea property="${questionFieldName}" style="" styleId="${questionFieldName}" title="Question Answer" tabindex="${tabindex}"
			rows="3" cols="80"
			styleClass="Qanswer answer questionnaireAnswer"
			onkeyup="textLimit(this, ${answerLength});" />
		<kul:expandedTextArea textAreaFieldName="${questionFieldName}" 
			action="questionnaire" textAreaLabel="Question Answer" maxLength="${question.answerMaxLength}" />
	</c:when>
	<c:otherwise>
		<c:set var="fieldSize" value="${answerLength}" />
		<c:if test="${answerLength > 80}">
			<c:set var="fieldSize" value="80" />
		</c:if>
		<input type="text" class="Qanswer answer questionnaireAnswer" id="${questionFieldName}" name="${questionFieldName}" maxlength="${question.answerMaxLength}" size="${fieldSize}" 
			value="${bean.answerHeaders[answerHeaderIndex].answers[questionIndex].answer}" />
	</c:otherwise>
</c:choose>
<c:if test="${answerValidationError}">
	<kul:fieldShowErrorIcon />
</c:if>
