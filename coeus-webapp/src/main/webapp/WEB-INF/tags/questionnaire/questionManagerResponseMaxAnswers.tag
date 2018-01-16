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
        <c:set var="preMessage" value="The number of possible answers is " />
        <c:set var="postMessage" value=", not exceeding the number of text boxes presented." />
        <c:set var="htmlControlDivStyle" value="display: inline" />
    </c:when>
    <c:when test="${currentQuestionType == 'Date'}">
        <c:set var="preMessage" value="The number of possible answers is " />
        <c:set var="postMessage" value=", not exceeding the number of text boxes presented." />
        <c:set var="htmlControlDivStyle" value="display: inline" />
    </c:when>
    <c:when test="${currentQuestionType == 'Text'}">
        <c:set var="preMessage" value="The number of possible answers is " />
        <c:set var="postMessage" value=", not exceeding the number of text areas presented." />
        <c:set var="htmlControlDivStyle" value="display: inline" />
    </c:when>
    <c:when test="${currentQuestionType == 'Lookup'}">
        <c:set var="preMessage" value="The number of possible returns is " />
        <c:set var="postMessage" value="." />
        <c:set var="htmlControlDivStyle" value="display: inline" />
    </c:when>
    <c:otherwise>
        <c:set var="preMessage" value="" />
        <c:set var="postMessage" value="" />
        <c:set var="htmlControlDivStyle" value="display: none" />
    </c:otherwise>
</c:choose>

<div id="max_answers_pre_message" style="display: inline">
    ${preMessage}
</div>
<div id="max_answers_html_control" style="${htmlControlDivStyle}">
    <kul:htmlControlAttribute property="document.newMaintainableObject.businessObject.maxAnswers" 
                              attributeEntry="${DataDictionary.Question.attributes.maxAnswers}" />
</div>
<div id="max_answers_post_message" style="display: inline">
    ${postMessage}
</div>
<div id="max_answers_br" style="${htmlControlDivStyle}">
    <br />
</div>
