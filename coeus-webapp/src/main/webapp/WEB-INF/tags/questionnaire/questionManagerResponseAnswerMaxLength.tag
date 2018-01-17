<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="currentQuestionType" value="${KualiForm.document.newMaintainableObject.businessObject.questionType.name}" />

<c:choose>
    <c:when test="${currentQuestionType == 'Number'}">
        <c:set var="preMessage" value="The maximum length of the number in characters is " />
        <c:set var="postMessage" value="." />
        <c:set var="htmlControlDivStyle" value="display: inline" />
    </c:when>
    <c:when test="${currentQuestionType == 'Text'}">
        <c:set var="preMessage" value="Maximum length of each response in characters: " />
        <c:set var="postMessage" value="." />
        <c:set var="htmlControlDivStyle" value="display: inline" />
    </c:when>
    <c:otherwise>
        <c:set var="preMessage" value="" />
        <c:set var="postMessage" value="" />
        <c:set var="htmlControlDivStyle" value="display: none" />
    </c:otherwise>
</c:choose>

<div id="answer_max_length_pre_message" style="display: inline">
    ${preMessage}
</div>
<div id="answer_max_length_html_control" style="${htmlControlDivStyle}">
    <kul:htmlControlAttribute property="document.newMaintainableObject.businessObject.answerMaxLength" 
                              attributeEntry="${DataDictionary.Question.attributes.answerMaxLength}" /> 
</div>
<div id="answer_max_length_post_message" style="display: inline">
    ${postMessage}
</div>
<div id="answer_max_length_br" style="${htmlControlDivStyle}">
    <br />
</div>
