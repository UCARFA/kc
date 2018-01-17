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

<c:set var="prop" value="${property}.answerHeaders[${answerHeaderIndex}].answers[${questionIndex}].answer"/>
${kfunc:registerEditableProperty(KualiForm, prop)}
        
<input type="text" class="QanswerDate" id="${prop}" name="${prop}" 
	onchange = "answerChanged(this,'${property}')" maxlength="10" size="10" value="${bean.answerHeaders[answerHeaderIndex].answers[questionIndex].answer}" />
<img src="kr/static/images/cal.gif" id="${prop}_datepicker" style="cursor: pointer;"
	title="Date selector" alt="Date selector"
	onmouseover="this.style.backgroundColor='red';" onmouseout="this.style.backgroundColor='transparent';" />
<script type="text/javascript">
     	Calendar.setup(
                  {
                    inputField : "${prop}", // ID of the input field
                    ifFormat : "%m/%d/%Y", // the date format
                    button : "${prop}_datepicker" // ID of the button
                  }
          );
</script>
<c:if test="${answerValidationError}">
	<kul:fieldShowErrorIcon />
</c:if>
