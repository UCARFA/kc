<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="readOnly" value="true" scope="request" />
<kul:page showDocumentInfo="false"
	      headerTitle="Budget Deleted"
	      docTitle="Budget Deleted"
	      transactionalDocument="false"
	      htmlFormAction="${KualiForm.actionPrefix}Parameters"
	      defaultMethodToCall="notify"
	      errorKey="*">

    <div class="topblurb">
		<div align="center">
			<table cellpadding="10" cellspacing="0" border="0" class="container2">
				<tr>
					<td>
						<div align="left" valign="top">
							<strong>Error Message</strong>
						</div>
					</td>
					<td align="left">
						<div align="left">
							<font color="red">The Budget has been deleted.</font>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td align="left">
						<div>
							<html:image property="methodToCall.close" value="true" 
								   src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_close.gif"
								   styleClass="tinybutton" title="close" alt="Close"/>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
  	
  	
  
  
</kul:page>
