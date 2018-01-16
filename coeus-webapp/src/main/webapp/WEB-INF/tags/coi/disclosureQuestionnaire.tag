<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:tab defaultOpen="${fn:length(KualiForm.screeningQuestionnaireHelper.answerHeaders) > 0}" tabTitle="Screening Questionnaire" transparentBackground="false" 
	auditCluster="coiQuestionnaireKey" tabAuditKey="screeningQuestionnaireHelper.*" useRiceAuditMode="true"
    tabErrorKey="" >
    
    <c:set var="answerHeaderIndex" value="0" />
	<c:set var="property" value="screeningQuestionnaireHelper" />
	<c:set var="bean" value="${KualiForm.screeningQuestionnaireHelper}" />
			
	<c:forEach items="${bean.answerHeaders}" var="answerHeader" varStatus="status">
         <div class="tab-container" align="center">
             <kra-questionnaire:questionnaireAnswersInnerTab bean="${bean}" property="${property}" 
             	answerHeaderIndex="${status.index}" parentTab="Questionnaire"/>
         </div>					 
	</c:forEach>
				
</kul:tab>
<kul:tab defaultOpen="true" tabTitle="Questionnaire" transparentBackground="false" 
	auditCluster="coiQuestionnaireKey" tabAuditKey="disclosureQuestionnaireHelper.*" useRiceAuditMode="true"
    tabErrorKey="" >
    
    <c:set var="answerHeaderIndex" value="0" />
	<c:set var="property" value="disclosureQuestionnaireHelper" />
	<c:set var="bean" value="${KualiForm.disclosureQuestionnaireHelper}" />
			
	<c:forEach items="${bean.answerHeaders}" var="answerHeader" varStatus="status">
       <c:choose>
           <c:when test="${KualiForm.document.coiDisclosureList[0].updateEvent or (KualiForm.document.coiDisclosureList[0].annualEvent and KualiForm.document.coiDisclosureList[0].annualUpdate)}">
              <c:if  test="${answerHeader.moduleSubItemCode == '14' or answerHeader.moduleSubItemCode == '6'}">
		         <div class="tab-container" align="center">
		             <kra-questionnaire:questionnaireAnswersInnerTab bean="${bean}" property="${property}" 
		             	answerHeaderIndex="${status.index}" parentTab="Questionnaire"/>
		         </div>					 
              </c:if>
           </c:when>
           <c:otherwise>
		         <div class="tab-container" align="center">
		             <kra-questionnaire:questionnaireAnswersInnerTab bean="${bean}" property="${property}" 
		             	answerHeaderIndex="${status.index}" parentTab="Questionnaire"/>
		         </div>					 
           </c:otherwise>
       </c:choose>
	</c:forEach>
				
</kul:tab>
