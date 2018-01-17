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
	htmlFormAction="institutionalProposalSpecialReview"
	documentTypeName="InstitutionalProposalDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="specialReview">
  	
<div align="right">
   <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
   <kul:help documentTypeName="InstitutionalProposalDocument" pageName="Special Review" />
</div>

<div id="workarea">
	<kra-specialreview:specialReviewPage businessObjectClassName="org.kuali.kra.institutionalproposal.specialreview.InstitutionalProposalSpecialReview"
	                                     attributes="${DataDictionary.InstitutionalProposalSpecialReview.attributes}"
	                                     exemptionAttributes="${DataDictionary.InstitutionalProposalSpecialReviewExemption.attributes}"
	                                     collectionReference="${KualiForm.document.institutionalProposal.specialReviews}"
	                                     collectionProperty="document.institutionalProposalList[0].specialReviews"
	                                     action="institutionalProposalSpecialReview" />
	
	<kul:panelFooter />
</div>

<kul:documentControls transactionalDocument="false" suppressRoutingControls="true" suppressCancelButton="true"/>
<script language="javascript" src="scripts/kuali_application.js"></script>

</kul:documentPage>
