<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<script src="scripts/jquery/jquery.js"></script>
<script type="text/javascript">
   var $j = jQuery.noConflict();
</script>
 
<kul:documentPage showDocumentInfo="true"
                  htmlFormAction="personMassChangeHome"
                  documentTypeName="PersonMassChangeDocument"
                  renderMultipart="false"
                  showTabButtons="true"
                  auditCount="0"
                  headerDispatch="${KualiForm.headerDispatch}"
                  headerTabActive="home">

<kul:documentOverview editingMode="${KualiForm.editingMode}" />
<kra-personmasschange:personMassChangePersonType />
<kra-personmasschange:personMassChangeReplace />

<kul:panelFooter />

<kul:documentControls transactionalDocument="true"
                      suppressRoutingControls="true"
                      extraButtonSource="${extraButtonSource}"
                      extraButtonProperty="${extraButtonProperty}"
                      extraButtonAlt="${extraButtonAlt}"
                      viewOnly="${KualiForm.editingMode['viewOnly']}" />

</kul:documentPage>
