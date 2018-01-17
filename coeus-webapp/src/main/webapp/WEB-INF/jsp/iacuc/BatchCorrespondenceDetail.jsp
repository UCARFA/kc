<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="readOnly" value="${KualiForm.readOnly}"  scope="request" />


<kul:page lookup="false" 
          docTitle="Batch Correspondence" 
          transactionalDocument="false"
          renderMultipart="true" 
          htmlFormAction="iacucBatchCorrespondenceDetail">

	<div align="left"><kul:help parameterNamespace="KC-IACUC" parameterDetailType="Document" parameterName="iacucBatchCorrespondenceHelpUrl" altText="help"/>
	<br />
    
    <div id="workarea">

<c:set var="parentTab" value = "IACUC Batch Correspondence" />

<kul:tab tabTitle="${parentTab}"
         defaultOpen="true"
         alwaysOpen="true"
         transparentBackground="true" 
         useCurrentTabIndexAsKey="true"
         tabErrorKey="batchCorrespondence.*,newBatchCorrespondenceDetail.*">
         
    <div class="tab-container" align="center" id="G100">
        <h3>
            <span class="subhead-left">IACUC Batch Correspondence</span>
            <span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.iacuc.correspondence.IacucBatchCorrespondenceDetail" altText="help" /></span>
        </h3>
        <table cellpadding="0" cellspacing="0" border="0">
           <kra-iacuc:batchCorrespondenceDetailType />
           <c:if test="${not empty KualiForm.batchCorrespondence.batchCorrespondenceTypeCode}">
               <kra-iacuc:batchCorrespondenceDetailDetails />
           </c:if>
        </table>
        
        
    </div> 
</kul:tab>

<kul:panelFooter />

<div id="globalbuttons" class="globalbuttons">
    <c:if test="${!readOnly}">
        <html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_save.gif" styleClass="globalbuttons" property="methodToCall.save" title="save" alt="save"/>
    </c:if>
    <html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_reload.gif" styleClass="globalbuttons" property="methodToCall.reload" title="reload" alt="reload" onclick="excludeSubmitRestriction=true"/>
    <html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_close.gif" styleClass="globalbuttons" property="methodToCall.close" title="close" alt="close"/>
    <c:if test="${!readOnly}">
        <html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_cancel.gif" styleClass="globalbuttons" property="methodToCall.cancel" title="cancel" alt="cancel"/>
    </c:if>
</div>
<hr>

</kul:page>
