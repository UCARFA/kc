<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:page lookup="false" 
          docTitle="New Projects For Disclosure" 
          transactionalDocument="false"
          renderMultipart="false"
          showTabButtons="true"
          htmlFormAction="projectEventDisclosure">
          
    <script language="javascript" src="scripts/kuali_application.js"></script>
    
    <div id="workarea">

<kra-coi:proposalEventListing topOfStack="true" />
<kra-coi:institutionalProposalEventListing />
<kra-coi:awardEventListing />
<kra-coi:protocolEventListing />
<kra-coi:iacucEventListing />

<kul:panelFooter />

<div id="globalbuttons" class="globalbuttons">
    <html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_close.gif" styleClass="globalbuttons" property="methodToCall.close" title="close" alt="close"/>
</div>

<script type="text/javascript">
   var $j = jQuery.noConflict();
   $j(document).ready(function () {
        $j('#horz-links').hide();
   }); // end document.ready
</script>

</kul:page>
