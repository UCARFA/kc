<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<script type="text/javascript">
   var $j = jQuery.noConflict();
</script>

<c:set var="readOnly" value="${KualiForm.readOnly}"  scope="request"/>

<kul:tab tabTitle="Question Manager" 
         defaultOpen="true" 
         useCurrentTabIndexAsKey="true"
         tabErrorKey="document.newMaintainableObject.*">
    <kra-questionnaire:questionManagerQuestion />
    <kra-questionnaire:questionManagerResponse />
    <kra-questionnaire:questionManagerQuestionMultiChoice />
    <kul:csrf />
</kul:tab>

<script type="text/javascript">
    $j(document).ready(function() {
        showQuestionType();
    });
</script>

<script type="text/javascript" src="scripts/questionMaint.js"/>

     <input type="hidden" id="docStatus" name="docStatus" value="${KualiForm.document.documentHeader.workflowDocument.status.code }"  />   
     <input type="hidden" id="readOnly" name="readOnly" value="${KualiForm.readOnly}"  />   

<script language="javascript">
        $j(document).ready(function(){
           if ($j("#readOnly").attr("value") == 'true' && $j("#docStatus").attr("value") == 'I') {
               $j("#tab-RouteLog-div").hide();
               $j("#tab-RouteLog-div").prev().hide();
           }

        });

 </script>

