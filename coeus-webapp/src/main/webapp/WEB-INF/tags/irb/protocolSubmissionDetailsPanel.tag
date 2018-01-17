<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="prevDisabled" value="false" />
<c:set var="nextDisabled" value="false" />
<c:set var="tabSubmissionDetails" value="submissionDetails" scope="request"/>
<c:set var="prevDisabled" value="${KualiForm.actionHelper.prevDisabled}" />
<c:set var="nextDisabled" value="${KualiForm.actionHelper.nextDisabled}" />
<c:set var="submissionHasNoAmendmentDetails" value= "${KualiForm.actionHelper.submissionHasNoAmendmentDetails}"/>

<kra:permission value="${fn:length(KualiForm.protocolDocument.protocol.protocolSubmissions) > 0}">

<kul:innerTab parentTab="Summary, History, & Print" defaultOpen="false" tabTitle="Submission Details">
    <div class="innerTab-container" align="left">
    <h3>
   			<span class="subhead-left">Submission Details</span>
   			<span class="subhead-right">
   				<kul:help parameterNamespace="KC-PROTOCOL" parameterDetailType="Document" parameterName="protocolSubmissionDetailsHelp" altText="Help"/>
			</span>
       </h3>
        <table class="tab" cellpadding="0" cellspacing="0" summary=""> 
            <tbody>
            <tr>
                <th align="right" width="50%" >Submission Navigation:
                </th>
                <th align="left" width="50%"> 
                    <div align="left">
                        <c:if test="${!prevDisabled}">
                            <html:image property="methodToCall.viewPreviousSubmission.line${KualiForm.actionHelper.currentSubmissionNumber - 1}.anchor${currentTabIndex}"
                                        src="${ConfigProperties.kra.externalizable.images.url}tinybutton-previous3.gif"
                                        styleClass="tinybutton"
                                        alt="View Previous Submission" 
                                        onclick="excludeSubmitRestriction = true;" />
                        </c:if>
                        <c:if test="${!nextDisabled}">
                            <html:image property="methodToCall.viewNextSubmission.line${KualiForm.actionHelper.currentSubmissionNumber + 1}.anchor${currentTabIndex}"
                                        src="${ConfigProperties.kra.externalizable.images.url}tinybutton-next3.gif"
                                        styleClass="tinybutton"
                                        alt="View Next Submission" 
                                        onclick="excludeSubmitRestriction = true;" />
                        </c:if>
                     </div>
                </th>
            </tr>
		    <kra-irb:submissionDetails />
 		    <kra-irb:reviewers />
		    <kra-irb:voteSummary />
		    <c:if test="${!submissionHasNoAmendmentDetails and KualiForm.actionHelper.hasAmendments or KualiForm.actionHelper.hasRenewals }" >
		      <kra-irb:amendmentSummary />
		    </c:if>
		    <kra-irb:checklistItems />
		    <kra-irb:protocolReviewComments />
		    <kra-irb:protocolReviewAttachments />
            </tbody>
        </table>
       
    </div>
    			
</kul:innerTab>

</kra:permission>
