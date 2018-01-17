<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="question" required="true" type="org.kuali.coeus.common.questionnaire.framework.question.Question" %>
<div class="Qmoreinfodiv">
    <span class="Qmoreinfo">
        ${question.questionSeqId} :  ${question.question} </br>
        <c:if test="${fn:length(question.questionExplanations) > 0}" >
            <c:forEach items="${question.questionExplanations}" var="questionExplanation" varStatus="status">
                <c:choose>
                    <c:when test="${questionExplanation.explanationType eq 'E'}">
                    Explanation : ${questionExplanation.explanation} </br>
                    </c:when>
                    <c:when test="${questionExplanation.explanationType eq 'P'}">
                    Policy : ${questionExplanation.explanation} </br>
                    </c:when>
                    <c:when test="${questionExplanation.explanationType eq 'R'}">
                    Regulation : ${questionExplanation.explanation} </br>
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:if>
    </span>
</div>
