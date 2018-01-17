<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="awardCreateAccountAttributes" value="${DataDictionary.Award.attributes}" />
<c:set var="accountInformationBean" value="${KualiForm.accountInformationBean}" />
<c:set var="accountInformationBeanAttributes" value="${DataDictionary.AccountInformationBean.attributes}" />

<kul:tab tabTitle="Create Account" defaultOpen="${param.command eq 'displayDocSearchView' ? true : false}" tabErrorKey="error.award.createAccount.*" >
	<div class="tab-container" align="left">
    	<h3> 
    		<span class="subhead-left">Account Information</span>
        </h3>        
		              
		<c:choose>
			<c:when test = "${!KualiForm.accountCreated}" >
		              
		               <table cellpadding=0 cellspacing=0 summary="">
        				<tr>
							<th>
								<div align="center">
									<kul:htmlAttributeLabel attributeEntry="${awardCreateAccountAttributes.accountNumber}" />
								</div>
							
							</th>
							<th>
							<div align="center"	>
									Actions
							</div>
						</th>
						</tr>
						<tr>
							<td class="infoline">
							
								<div align="center">				
										<kul:htmlControlAttribute property="document.award.accountNumber"  attributeEntry="${awardCreateAccountAttributes.accountNumber}" readOnly="false"/>								
								</div>
							</td>
							<td class="infoline">
								<div align="center">
						   			<html:image property="methodToCall.createAccount" src="${ConfigProperties.kra.externalizable.images.url}tinybutton-createAccount.gif" title="create award account" alt="create award account" styleClass="tinybutton"/>
								</div>
							</td>
						</tr>
						</table>
		    </c:when>
			<c:otherwise>
                <c:choose>
                <%-- If the account has been created and the financial doc number is null, it means we are using the REST apis.--%>
                <c:when test = "${KualiForm.document.award.financialAccountDocumentNumber == null}">
                    <table cellpadding=0 cellspacing=0 summary="">
                        <tr>
                            <th><div>
                                <kul:htmlAttributeLabel attributeEntry="${awardCreateAccountAttributes.accountNumber}" />
                            </div>
                            </th>
                            <td class="infoline">
                                <div>
                                    <c:out value="${KualiForm.document.award.accountNumber}" />
                                </div>
                            </td>
                        </tr>
                        <c:choose>
                            <c:when test="${KualiForm.isDisplayAccountBalances()}">
                            <tr>
                                <th>
                                    <div>
                                        <kul:htmlAttributeLabel attributeEntry="${accountInformationBeanAttributes.budgeted}" />
                                    </div>

                                </th>
                                <td class="infoline">
                                    <div>
                                        <fmt:formatNumber value="${accountInformationBean.budgeted}" type="currency" currencySymbol="" maxFractionDigits="2" />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <div>
                                        <kul:htmlAttributeLabel attributeEntry="${accountInformationBeanAttributes.pending}" />
                                    </div>

                                </th>
                                <td class="infoline">
                                    <div>
                                        <fmt:formatNumber value="${accountInformationBean.pending}" type="currency" currencySymbol="" maxFractionDigits="2" />
                                    </div>
                                </td>
                            </tr>
                        <tr>
                            <th>
                                <div>
                                    <kul:htmlAttributeLabel attributeEntry="${accountInformationBeanAttributes.income}" />
                                </div>

                            </th>
                            <td class="infoline">
                                <div>
                                    <fmt:formatNumber value="${accountInformationBean.income}" type="currency" currencySymbol="" maxFractionDigits="2" />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <div>
                                    <kul:htmlAttributeLabel attributeEntry="${accountInformationBeanAttributes.expense}" />
                                </div>

                            </th>
                            <td class="infoline">
                                <div>
                                    <fmt:formatNumber value="${accountInformationBean.expense}" type="currency" currencySymbol="" maxFractionDigits="2" />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <div>
                                    <kul:htmlAttributeLabel attributeEntry="${accountInformationBeanAttributes.available}" />
                                </div>

                            </th>
                            <td class="infoline">
                                <div>
                                    <fmt:formatNumber value="${accountInformationBean.available}" type="currency" currencySymbol="" maxFractionDigits="2" />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <div>
                                    <kul:htmlAttributeLabel attributeEntry="${accountInformationBeanAttributes.comment}" />
                                </div>
                            </th>
                            <td class="infoline">
                                <div>
                                    <c:out value="${accountInformationBean.comment}"/>
                                </div>
                            </td>
                         </tr>
                         </c:when>
                        </c:choose>
                    </table>
                </c:when>
                <c:otherwise>
				    <table cellpadding=0 cellspacing=0 summary="">
        				    <tr>
							    <th><div align="center">
									    <kul:htmlAttributeLabel attributeEntry="${awardCreateAccountAttributes.financialAccountDocumentNumber}" />
								    </div>
							    </th>
							    <th>
							    <div align="center"	>
							        Account creation date
							    </div>
							    </th>
						    </tr>
						    <tr>
							    <td class="infoline">
								    <div align="center">
									    <c:out value="${KualiForm.document.award.financialAccountDocumentNumber}" />
								    </div>
							    </td>
							    <td class="infoline">
								    <div align="center">
								    <fmt:formatDate value="${KualiForm.document.award.financialAccountCreationDate}" pattern="MM/dd/yyyy" />
								    </div>
							    </td>
						    </tr>
				    </table>
                </c:otherwise>
                </c:choose>
			</c:otherwise>
        </c:choose>
	</div>
</kul:tab>

