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
	htmlFormAction="timeAndMoneySummaryAndHistory"
	documentTypeName="TimeAndMoneyDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="timeAndMoneySummaryAndHistory"
  	extraTopButtons="${KualiForm.extraTopButtons}" >
  	
<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />


<script language="JavaScript" type="text/javascript" src="dwr/util.js"></script>
	
<link rel="stylesheet" href="css/jquery/screen.css" type="text/css" />
<link rel="stylesheet" href="css/jquery/new_kuali.css" type="text/css" />
<link rel="stylesheet" href="css/jquery/kuali-stylesheet.css" type="text/css" />
<link rel="stylesheet" href="css/jquery/jquery.treeview.css" type="text/css" />
	<link rel="stylesheet" href="css/jquery/new_kuali.css" type="text/css" />
	<link rel="stylesheet" href="css/jquery/kuali-stylesheet.css" type="text/css" />
	<link rel="stylesheet" href="css/jquery/jquery.treeview.css" type="text/css" />

<script type="text/javascript" src="scripts/jquery/jquery.treeview.js"></script>
	
<div align="right"><kul:help documentTypeName="TimeAndMoneyDocument" pageName="Time And Money" /></div>
<div id="workarea">
<kra-timeandmoney:actionSummary />
<kra-timeandmoney:timeAndMoneyHistory />
<kul:panelFooter />
</div>

<SCRIPT type="text/javascript">
var kualiForm = document.forms['KualiForm'];
var kualiElements = kualiForm.elements;
</SCRIPT>
<script language="javascript" src="scripts/kuali_application.js"></script>

<c:if test="${readOnly}">
	<c:set var="extraButtons" value="${KualiForm.extraButtons}" scope="request"/>
</c:if>

<kul:documentControls transactionalDocument="true" suppressRoutingControls="true"
													extraButtons="${extraButtons}"
													extraButtonSource="${extraButtonSource}" 
													extraButtonProperty="${extraButtonProperty}"
													extraButtonAlt="${extraButtonAlt}" />

</kul:documentPage>
