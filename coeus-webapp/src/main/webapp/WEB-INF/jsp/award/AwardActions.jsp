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
	htmlFormAction="awardActions"
	documentTypeName="AwardDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="awardActions"
  	extraTopButtons="${KualiForm.extraTopButtons}" >
  	
  	<div align="right">
		<kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
  	    <kul:help parameterNamespace="KC-AWARD" parameterDetailType="Document" parameterName="awardActionsHelpUrl" altText="help"/>    
</div>
  	
  	
  	<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />
  	<c:set var="extraButtons" value="${KualiForm.extraActionsButtons}" scope="request" />
  	<script>
	  $j = jQuery.noConflict();
	</script>


	<script language="JavaScript" type="text/javascript" src="dwr/util.js"></script>
		
	<link rel="stylesheet" href="css/jquery/new_kuali.css" type="text/css" />
	<link rel="stylesheet" href="css/jquery/kuali-stylesheet.css" type="text/css" />
	<link rel="stylesheet" href="css/jquery/jquery.treeview.css" type="text/css" />
	<script>
	  $j = jQuery.noConflict();
	</script>
    <script type="text/javascript" src="scripts/jquery/jquery.treeview.js"></script>   	
  	
  	  	
<kra-a:awardDataValidation /> 
<kra-a:awardHierarchy />
<kra-a:awardSync />
<kra-a:awardPrint />
<kul:adHocRecipients />
<kul:routeLog />
<kul:superUserActions showTab="false"/>			

<kra:section permission="createAwardAccount">
<kra-a:awardCreateAccount />
</kra:section>

<kra:section permission="postAward">
    <kra-a:awardPostHistory />
</kra:section>
<kra:section permission="postTimeAndMoney">
    <kra-a:tmPostHistory />
</kra:section>

    <kul:panelFooter />
<kul:documentControls transactionalDocument="true"
                      extraButtonSource="${extraButtonSource}"
                      extraButtonProperty="${extraButtonProperty}"
                      extraButtonAlt="${extraButtonAlt}" 
                      extraButtons="${extraButtons}" />

</kul:documentPage>
<script type="text/javascript" src="scripts/awardHierarchyShared.js"></script>
<script type="text/javascript" src="scripts/awardHierarchy.js"></script>		
