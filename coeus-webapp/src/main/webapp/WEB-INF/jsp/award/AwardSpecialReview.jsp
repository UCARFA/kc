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
	htmlFormAction="awardSpecialReview"
	documentTypeName="AwardDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="specialReview"
  	extraTopButtons="${KualiForm.extraTopButtons}" >

<div align="right">
	<kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
	<kul:help parameterNamespace="KC-AWARD" parameterDetailType="Document" parameterName="awardSpecialReviewHelpUrl" altText="help"/>
</div>

<div id="workarea">
	<kra-specialreview:specialReviewPage businessObjectClassName="org.kuali.kra.award.specialreview.AwardSpecialReview"
	                                     attributes="${DataDictionary.AwardSpecialReview.attributes}"
	                                     exemptionAttributes="${DataDictionary.AwardSpecialReviewExemption.attributes}"
	                                     collectionReference="${KualiForm.document.award.specialReviews}"
	                                     collectionProperty="document.awardList[0].specialReviews"
	                                     action="awardSpecialReview" />
	
	<kul:panelFooter />
</div>

<kul:documentControls transactionalDocument="false" suppressRoutingControls="true" suppressCancelButton="true" />
<script language="javascript" src="scripts/kuali_application.js"></script>

</kul:documentPage>
