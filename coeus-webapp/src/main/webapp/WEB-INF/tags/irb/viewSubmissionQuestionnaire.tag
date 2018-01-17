<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<tr>
<td colspan="2">
<table width="100%" cellspacing="0" cellpadding="0">
			<tbody>
                            <tr>
                                <th class="tab-subhead" align="left" >
                                <div align="right">
                                               Questionnaire:
                                               </div>
                                </th>
                                <td align="left" valign="middle" width="85%">
                                    <div align="left">
							        <html:image property="methodToCall.questionnaire.actionType116.anchor${currentTabIndex}"
								        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-questionnaire.gif' styleClass="tinybutton"
									onclick="questionnairePop('${KualiForm.document.protocolList[0].protocolNumber}','${KualiForm.actionHelper.selectedSubmission.submissionNumber}','${KualiForm.formKey}',' ${KualiForm.document.sessionDocument}', false); return false;"
								        alt="View Questionnaire" />
                                     </div>
                                  </td>
                            </tr>
           	</tbody>
           	</table>	
        </td>
</tr>
           	
