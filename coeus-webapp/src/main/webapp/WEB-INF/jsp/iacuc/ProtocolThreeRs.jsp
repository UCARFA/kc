<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="protocolPrinciples" value="${DataDictionary.IacucPrinciples.attributes}" />
<c:set var="protocolAlternateSearch" value="${DataDictionary.IacucAlternateSearch.attributes}" />


<kul:documentPage
    showDocumentInfo="true"
    htmlFormAction="iacucProtocolThreeRs"
    documentTypeName="IacucProtocolDocument"
    renderMultipart="false"
    showTabButtons="true"
    auditCount="0"
    headerDispatch="${KualiForm.headerDispatch}"
    headerTabActive="threeRs">

<script type="text/javascript" src="scripts/jquery/jquery.multiselects.js" /></script>    
<script type="text/javascript">
   var $j = jQuery.noConflict();
   
   function alternateSearchRequired(element) {
	   if (element.value == 'Y') {
		   $j("#alternate-search-div").show();
	   } else {
		   $j("#alternate-search-div").hide();
	   }
   }

   function addOtherDatabase() {
	   var inputField = $j("#otherAltSearchDatabase");
	   var inputVal = inputField.val().trim();
	   
	   if (inputVal != '') {
		   var newDatabaseField = document.getElementsByName('iacucAlternateSearchHelper.newDatabases')[0];
		   var opt = new Option(inputVal, inputVal);
		   opt.selected = true;
		   newDatabaseField.options[newDatabaseField.length] = opt;
		   inputField.val('');
	   } else {
		   window.alert('Please enter a valid other database name.');
	   }
   }
   
   $j(document).ready(function() {
		var selectEn = document.getElementsByName("document.protocolList[0].iacucPrinciples[0].searchRequired");
	    alternateSearchRequired(selectEn[0]);
	    
	    var options = {
	        button_select: "#move_right",
	        button_deselect: "#move_left"
        };
        $j("#iacucAlternateSearchHelper\\.newAlternateSearch\\.databases").multiSelect("#new-databases-select", options);	    
   });   
</script>

	<div align="right">
        <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
        <kul:help documentTypeName="IacucProtocolDocument" pageName="The Three R's" />
    </div>

<kra-iacuc:iacucProtocolPrinciples 
    protocolPrinciples="${protocolPrinciples}" />
<kra-iacuc:iacucProtocolAlternateSearch
    protocolAlternateSearch="${protocolAlternateSearch}"
    modifyPermissions="${KualiForm.iacucAlternateSearchHelper.modifyPermissions}" />   

<kul:panelFooter />

    <kul:documentControls 
        transactionalDocument="false"
        suppressRoutingControls="true"
        extraButtonSource="${extraButtonSource}"
        extraButtonProperty="${extraButtonProperty}"
        extraButtonAlt="${extraButtonAlt}"
        viewOnly="${KualiForm.editingMode['viewOnly']}"
        />

</kul:documentPage>    
