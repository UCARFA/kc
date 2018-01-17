<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="readOnly" value="${!KualiForm.committeeHelper.performAction}"  scope="request" />
<kul:documentPage 
    showDocumentInfo="true"
    htmlFormAction="iacucCommitteeActions" 
    documentTypeName="CommonCommitteeDocument"
    renderMultipart="false" 
    showTabButtons="true" 
    auditCount="0"
    headerDispatch="${KualiForm.headerDispatch}"
    headerTabActive="committeeActions">

    <div align="right"><kul:help documentTypeName="CommonCommitteeDocument" pageName="Actions" /></div>
    
    <c:choose>
        <c:when test="${readOnly}">
            No Actions Available
        </c:when>
        <c:otherwise>
            <kra-committee:iacucCommitteeActionBatchCorrespondence />
            <kra-committee:committeeActionPrint />
        </c:otherwise>
    </c:choose>

    <kul:documentControls 
        transactionalDocument="false"
        suppressRoutingControls="false"
        extraButtonSource="${extraButtonSource}"
        extraButtonProperty="${extraButtonProperty}"
        extraButtonAlt="${extraButtonAlt}"
        viewOnly="${KualiForm.editingMode['viewOnly']}" />
       
    <script type="text/javascript">
        var kualiForm = document.forms['KualiForm'];
        var kualiElements = kualiForm.elements;
        var $j = jQuery.noConflict(); 
        // jquery checks if any checkbox has been select for viewing
        $j("a#viewBatchCorrespondenceGenerated").click(function() {
            var checked = false;           
            $j("#correspondanceDetails").find(":checkbox").each(function () {
                if (this.checked) {
                    checked = true;
                }
           	});
           	if (checked == false) {
               	alert ("No correspondence selected for viewing.");
               	return false;
           	}		
    	});
        $j("a#viewBatchCorrespondenceHistory").click(function() {
            var checked = false;
            
            $j("#historyDetails").find(":checkbox").each(function () {
                if (this.checked) {
                    checked = true;
                }
           	});
           	if (checked == false) {
               	alert ("No correspondence in history selected for viewing.");
               	return false;
           	}		
    	});
    </script>

    <script language="javascript" src="scripts/kuali_application.js"></script>
    <script language="javascript" src="dwr/interface/UnitService.js"></script>
</kul:documentPage>
