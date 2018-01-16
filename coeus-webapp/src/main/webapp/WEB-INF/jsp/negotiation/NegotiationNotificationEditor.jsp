<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:documentPage showDocumentInfo="true"
                  htmlFormAction="negotiationNotificationEditor"
                  documentTypeName="NegotiationDocument"
                  renderMultipart="false"
                  showTabButtons="true"
                  auditCount="0">

<div id="workarea">
    <kra-notification:notificationEditor />
    <kul:panelFooter />
</div>

<div id="globalbuttons" class="globalbuttons">
    <html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_save.gif" styleClass="globalbuttons" property="methodToCall.sendNotification" title="save" alt="save" tabindex="${tabindex}" />
    <html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_cancel.gif" styleClass="globalbuttons" property="methodToCall.cancelNotification" title="cancel" alt="cancel" tabindex="${tabindex}" />
</div>
  
</kul:documentPage>
