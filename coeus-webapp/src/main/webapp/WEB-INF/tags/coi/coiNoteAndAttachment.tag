<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>


<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<script type="text/javascript">
 //  var $j = jQuery.noConflict();
</script>
 <SCRIPT type="text/javascript">
var kualiForm = document.forms['KualiForm'];
var kualiElements = kualiForm.elements;

</SCRIPT>
<kul:tab tabTitle="Notes & Attachments" tabItemCount="${tabItemCount}" defaultOpen="false" tabErrorKey="coiNotesAndAttachmentsHelper.newCoiDisclosureAttachment.*, coiNotesAndAttachmentsHelper.newCoiDisclosureNotepad.*">

	<kra-coi:coiNotes />
	<kra-coi:coiAttachments />

</kul:tab>


