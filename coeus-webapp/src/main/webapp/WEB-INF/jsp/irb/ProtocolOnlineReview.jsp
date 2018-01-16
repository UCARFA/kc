<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ page import="org.kuali.kra.infrastructure.Constants"%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="protocolOnlineReview"
	documentTypeName="ProtocolDocument"
	renderMultipart="true"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="onlineReview">

<script type="text/javascript">
    var $j = jQuery.noConflict();
    
    function checkForUnprocessedComments(id) {
    	var commentValue = document.getElementById(id).value;
    	if (commentValue && commentValue.length > 0) {
    		return confirm("You have unsaved changes in your comments section, do you wish to proceed anyway?");
    	} else {
    		return true;
    	}
    }
</script>



<c:set var="protocolAttributes" value="${DataDictionary.ProtocolDocument.attributes}" />

<style type="text/css">
   .compare { color: #666666 }
   .compare td, .compare th { color:#666666; }
</style>


<c:choose>
	<c:when test = "${KualiForm.editingMode['maintainProtocolOnlineReviews']}">
	<!--  IRB ADMIN VIEW  -->
		<kul:tabTop tabTitle="Create New Online Review" defaultOpen="true" tabErrorKey="${Constants.DOCUMENT_ERRORS},onlineReviewsActionHelper.new*" >
			<div class="tab-container" align=center>
				<kra-irb-olr:newOnlineReview/>
			</div>
		</kul:tabTop>
		<c:forEach items = "${KualiForm.onlineReviewsActionHelper.protocolOnlineReviewsForCurrentSubmission}" var = "review" varStatus = "status">
			
			<c:set var = "documentHelperMap" value = "${KualiForm.onlineReviewsActionHelper.documentHelperMap[review.documentNumber]}"/>
	
			<kul:tab tabTitle="Online Review: ${review.protocolOnlineReview.protocolReviewer.fullName}" defaultOpen="true" tabErrorKey="onlineReviewsActionHelper.protocolOnlineReviewsReviewCommentsList[${status.index}]*,onlineReviewsActionHelper.protocolOnlineReviewDocuments[${status.index}].protocolOnlineReview*" >
				<kra-irb-olr:onlineReview renderIndex = "${status.index}" documentNumber="${review.documentNumber}"/>
			</kul:tab>
		</c:forEach>
	</c:when>

	<c:otherwise>
		<!--  PROTOCOL ONLINE REVIEWER VIEW -->
		<c:set var="protocolOnlineReviewDocument" value="${KualiForm.onlineReviewsActionHelper.documentForCurrentUser}"/> 
		<c:set var="indexForReviewer" value = "${KualiForm.onlineReviewsActionHelper.documentIndexForCurrentUser}"/>	
						
		<kul:tabTop tabTitle="Online Review: ${protocolOnlineReviewDocument.protocolOnlineReview.protocolReviewer.fullName}" defaultOpen="true" tabErrorKey="onlineReviewsActionHelper.protocolOnlineReviewsReviewCommentsList[${indexForReviewer}]*,onlineReviewsActionHelper.protocolOnlineReviewDocuments[${indexForReviewer}].protocolOnlineReview*" >
			<kra-irb-olr:onlineReview renderIndex = "${KualiForm.onlineReviewsActionHelper.documentIndexForCurrentUser}" documentNumber="${protocolOnlineReviewDocument.documentNumber}" />
		</kul:tabTop>

	</c:otherwise>
</c:choose>

<kul:panelFooter />
<%-- <kul:panelFooter /> --%>
	<kul:documentControls 
		transactionalDocument="true"
		suppressRoutingControls="true"
		suppressCancelButton="true"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		viewOnly="${KualiForm.editingMode['viewOnly']}"
		/>


<script language="javascript">enableJavaScript()</script>

</kul:documentPage>
