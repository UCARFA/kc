<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="actionTypeCode" required="true" %>
<%@ attribute name="altLabel" required="true" %>

    <c:if test = "${KualiForm.actionHelper.toAnswerSubmissionQuestionnaire}" >
                <table cellpadding="0" cellspacing="0" summary="">
                    <tr>
                        <td class="subhead" >Questionnaire</td>
                    </tr>
                    <tr>
					        <td align="left" valign="middle">
						        <div align="left">
							        <html:image property="methodToCall.submissionQuestionnaire.actionType${actionTypeCode}.anchor${currentTabIndex}"
								        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-questionnaire.gif' styleClass="tinybutton"
									    onclick="questionnairePop('${KualiForm.document.protocolList[0].protocolNumber}T', '${actionTypeCode}','${KualiForm.formKey}',' ${KualiForm.document.sessionDocument}'); return false;"
								        alt="${altLabel}" />
						        </div>
					        </td>
	         	        </tr>
                    
                </table>
                                                
    </c:if>
