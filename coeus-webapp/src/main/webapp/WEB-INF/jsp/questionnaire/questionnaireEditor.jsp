<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<link rel="stylesheet" href="css/jquery/new_kuali.css" type="text/css" />
<link rel="stylesheet" href="css/jquery/kuali-stylesheet.css" type="text/css" />
<link rel="stylesheet" href="css/jquery/jquery.treeview.css" type="text/css" />
<script type="text/javascript" src="scripts/jquery/jquery.treeview.js"></script>
<script type="text/javascript" src="scripts/jquery/CalendarPopup.js"></script>
<script>var jsContextPath = "${pageContext.request.contextPath}";</script>


<kul:tab defaultOpen="true" tabTitle="Questionnaire Details, Content & Use "
    tabErrorKey="document.newMaintainableObject.businessObject*">
    <c:choose>
      <c:when test = "${KualiForm.document.newMaintainableObject.maintenanceAction eq 'Copy' and !(KualiForm.document.documentHeader.workflowDocument.status.code eq 'F')}">
        <kra-questionnaire:questionnaireMaintCopy />      
      </c:when>
      <c:otherwise>
    <kra-questionnaire:questionnaireMaintCore />
    <kra-questionnaire:questionnaireQuestion />
    <kra-questionnaire:questionnaireMaintUsage />
      </c:otherwise>
     </c:choose>
    <kul:csrf />
</kul:tab>
    <input type="hidden" id="maintAction" name="maintAction" value = "${KualiForm.document.newMaintainableObject.maintenanceAction}"/>
     <input type="hidden" id="docStatus" name="docStatus" value="${KualiForm.document.documentHeader.workflowDocument.status.code }"  />   
     <input type="hidden" id="readOnly" name="readOnly" value="${KualiForm.readOnly}"  />   

<script type="text/javascript" src="scripts/questionnaireMaint.js"></script>





</script>
