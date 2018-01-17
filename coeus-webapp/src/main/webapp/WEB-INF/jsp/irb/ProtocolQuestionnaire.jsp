<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="questionnaire"
	documentTypeName="${KualiForm.docTypeName}"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="questionnaire">
  	
<script type="text/javascript">
   var $j = jQuery.noConflict();
</script>
    <link rel="stylesheet" href="css/jquery/questionnaire.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery/new_kuali.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery/kuali-stylesheet.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery/jquery.treeview.css" type="text/css" />
    <script type="text/javascript" src="scripts/jquery/jquery.treeview.js"></script>
    <script type="text/javascript" src="scripts/jquery/CalendarPopup.js"></script>
    
  	<div align="right">
        <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
        <kul:help documentTypeName="ProtocolDocument" pageName="Questionnaire" />
    </div>
	<kra-irb:protocolQuestionnaireAnswers property = "questionnaireHelper" bean = "${KualiForm.questionnaireHelper}"/>
	<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" />
   	
    <script type="text/javascript" src="scripts/questionnaireAnswer.js"></script>
  	
  	
</kul:documentPage>
