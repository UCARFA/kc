<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ page import="org.kuali.kra.infrastructure.Constants"%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="coiDisclosureActions"
	documentTypeName="CoiDisclosureDocument"
	renderMultipart="true"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="disclosureActions">

	<script type="text/javascript">
	   var $j = jQuery.noConflict();
	   $j(document).ready(function() {

       	if ($j(".financialEntitySubpanel").length > 0) {
            $j(".financialEntitySubpanel").toggle(
                     function()
                     {
                         var controlId = $j(this).attr("id");
                         var contentId = controlId.replace("Control","Content");
                         $j("#"+contentId).slideDown(500);
                         $j(this).html("<img src='kr/images/tinybutton-hide.gif' alt='show/hide panel' width='45' height='15' border='0' align='absmiddle'>");
                     },function(){
                         var controlId = $j(this).attr("id");
                         var contentId = controlId.replace("Control","Content");
                         $j("#"+contentId).slideUp(500);
                         $j(this).html("<img src='kr/images/tinybutton-show.gif' alt='show/hide panel' width='45' height='15' border='0' align='absmiddle'>");
                     }
            );
            $j(".financialEntitySubpanel").click();
        }
		   
       	if ($j(".projectsFESubpanel").length > 0) {
            $j(".projectsFESubpanel").toggle(
                     function()
                     {
                    	 var controlId = $j(this).attr("id");
                         var contentId = controlId.replace("Control","Content");
                         $j("#"+contentId).hide();
                         $j(this).html("<img src='kr/images/tinybutton-show.gif' alt='show/hide panel' width='45' height='15' border='0' align='absmiddle'>");
                     },function(){
                         var controlId = $j(this).attr("id");
                         var contentId = controlId.replace("Control","Content");
                         $j("#"+contentId).slideDown(500);
                         $j(this).html("<img src='kr/images/tinybutton-hide.gif' alt='show/hide panel' width='45' height='15' border='0' align='absmiddle'>");
                     }
            );
            $j(".projectsFESubpanel").click();
        }
	   
	   });
	</script>

   	<div align="right"><kul:help parameterNamespace="KC-COIDISCLOSURE" parameterDetailType="Document" parameterName="disclosureActionsHelp" altText="help"/></div>
	<div id="workarea">
	<%--Added condition to prevent Reviewer Actions panel from displaying when user is the reporter.            --%>
	<%--Added variable to designate top tab to keep Data Validation tab from having shadow when it was top tab. --%>  
	<c:set var="onTopTab" value="true" />
	<c:set var="userDisclosureReporter" value="${KualiForm.disclosureActionHelper.userDisclosureReporter}" />
	<c:if test="${not userDisclosureReporter}">
	    <kra-coi:disclosureReviewerActions  topTab="onTopTab"/>
	    <c:set var="onTopTab" value="false" />
	</c:if>
    
    <kra:section permission="approveCoiDisclosure">
        <kra-coi:coiAdministratorActions />
    </kra:section>
    
	<kra:dataValidation auditActivated="${KualiForm.auditActivated}" topTab="${onTopTab}"
		   helpParameterNamespace = "KC-COIDISCLOSURE" helpParameterDetailType = "Document" helpParameterName = "disclDataValidationHelp"/>
    
	<kul:panelFooter />
		<kul:documentControls 
			transactionalDocument="false"
			suppressRoutingControls="true"
			extraButtonSource="${extraButtonSource}"
			extraButtonProperty="${extraButtonProperty}"
			extraButtonAlt="${extraButtonAlt}"
			viewOnly="false"
			/>

	<SCRIPT type="text/javascript">
		var kualiForm = document.forms['KualiForm'];
		var kualiElements = kualiForm.elements;	
	</SCRIPT>

</kul:documentPage>
