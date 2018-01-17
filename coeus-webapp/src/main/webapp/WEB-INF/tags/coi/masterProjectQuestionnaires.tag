<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="disclProjectBean" required="true" type="org.kuali.kra.coi.disclosure.CoiDisclosureProjectBean" description="A List of active or inactive FE" %>
<%@ attribute name="boLocation" required="true" %>
<%@ attribute name="parentTab" required="true" description="name for project parent tab" %>

    <c:set var="answerHeaderIndex" value="0" />
    <c:set var="property" value="${boLocation}.projectQuestionnaireHelper" />
            
            
    <c:forEach items="${disclProjectBean.answerHeaders}" var="answerHeader" varStatus="ahstatus">
        <c:set var="prop" value="${property}.answerHeaders[${ahstatus.index}].showQuestions"/>
        ${kfunc:registerEditableProperty(KualiForm, prop)}
        <input type="hidden" name="${prop}" id ="${prop}" 
               value = "${bean.answerHeaders[ahstatus.index].showQuestions}" />
        <kra-questionnaire:questionnaireAnswersInnerTab bean="${disclProjectBean.projectQuestionnaireHelper}" property="${property}" answerHeaderIndex="${ahstatus.index}" parentTab="${parentTab}"/>
    </c:forEach>
