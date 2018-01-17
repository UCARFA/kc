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

<%@ attribute name="answerHeaderIndex" required="true" %>
<%@ attribute name="bean" required="true" type="org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireHelperBase" %>
<%@ attribute name="property" required="true" %>
<%@ attribute name="answerValidationError" required = "true" %>

<%@ attribute name="questionIndex" required="true" %>
        
<c:set var="prop" value="${property}.answerHeaders[${answerHeaderIndex}].answers[${questionIndex}].answer"/>
${kfunc:registerEditableProperty(KualiForm, prop)}
<jsp:useBean id="paramMap" class="java.util.HashMap"/>
<c:set target="${paramMap}" property="argName" value="${question.lookupReturn}" />
<c:set var="answer" value="${bean.answerHeaders[answerHeaderIndex].answers[questionIndex].answer}"/>
<html:select property="${prop}" tabindex="0"  styleClass="Qanswer answer questionnaireAnswer">
	<c:forEach items="${krafn:getOptionList('org.kuali.coeus.common.impl.custom.arg.ArgValueLookupValuesFinder', paramMap)}" var="option">
    	<option value="${option.key}" ${answer == option.key ? 'selected' : ''}>${option.value}</option>
	</c:forEach>
</html:select>		                    
