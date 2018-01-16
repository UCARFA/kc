<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="protocolSpecialReview"
	documentTypeName="ProtocolDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="specialReview">

<div align="right">
   <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
   <kul:help documentTypeName="ProtocolDocument" pageName="Special Review" />
</div>

<div id="workarea">
	<kra-specialreview:specialReviewPage businessObjectClassName="org.kuali.kra.irb.specialreview.ProtocolSpecialReview"
	                                     attributes="${DataDictionary.ProtocolSpecialReview.attributes}"
	                                     exemptionAttributes="${DataDictionary.ProtocolSpecialReviewExemption.attributes}"
	                                     collectionReference="${KualiForm.document.protocol.specialReviews}"
	                                     collectionProperty="document.protocolList[0].specialReviews"
	                                     action="protocolSpecialReview" />
	
	<kul:panelFooter />
</div>

<kul:documentControls transactionalDocument="false" suppressRoutingControls="true" />

</kul:documentPage>
