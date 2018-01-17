<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
 
<kul:documentPage showDocumentInfo="true"
                  htmlFormAction="personMassChangeView"
                  documentTypeName="PersonMassChangeDocument"
                  renderMultipart="false"
                  showTabButtons="true"
                  auditCount="0"
                  headerDispatch="${KualiForm.headerDispatch}"
                  headerTabActive="view">
                  
<kra-personmasschange:personMassChangeView />

<kul:panelFooter />

<kul:documentControls transactionalDocument="true"
                      suppressRoutingControls="false"
                      extraButtonSource="${extraButtonSource}"
                      extraButtonProperty="${extraButtonProperty}"
                      extraButtonAlt="${extraButtonAlt}"
                      viewOnly="${KualiForm.editingMode['viewOnly']}" />

</kul:documentPage>
