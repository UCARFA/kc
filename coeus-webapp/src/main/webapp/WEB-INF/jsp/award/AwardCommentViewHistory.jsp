<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="awardCommentTypeDescription" value="${KualiForm.awardCommentHistoryByType[0].commentType.description}" />

<kul:documentPage
    showDocumentInfo="true"
    htmlFormAction="awardNotesAndAttachments"
    documentTypeName="AwardDocument"
    renderMultipart="false"
    showTabButtons="false"
    auditCount="0"
    headerTabActive="actions">

<kul:tabTop tabTitle="${awardCommentTypeDescription} History" defaultOpen="true">

   <c:forEach var="awardComment" items="${KualiForm.awardCommentHistoryByType}">
     <kul:innerTab parentTab="Comments" defaultOpen="true" tabTitle="${awardComment.updateTimestampDateString}" tabErrorKey="" useCurrentTabIndexAsKey="true">
		<table>
		<tr>
        	<th width="200" align="left" scope="row"><div align="left">Comments:</div></th>
        	<td>
            	 <div align="left">
		 			<c:out value="${awardComment.comments}" />
            	  </div>	 
            </td>	     	 
    	</tr>
        </table>
  	</kul:innerTab>	
  </c:forEach>

</kul:tabTop>
<kul:panelFooter />

</kul:documentPage>
