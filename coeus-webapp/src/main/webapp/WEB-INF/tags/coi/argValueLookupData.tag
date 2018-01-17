<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="valueIndex" required="true" %>
<%@ attribute name="bean" required="true" type="org.kuali.kra.coi.personfinancialentity.FinEntityDataMatrixBean" %>
<%@ attribute name="property" required="true" %>
        ${kfunc:registerEditableProperty(KualiForm, property)}
                        <jsp:useBean id="paramMap" class="java.util.HashMap"/>
                        <c:set target="${paramMap}" property="argName" value="${bean.lookupArgument}" />

                            <html:select property="${property}" tabindex="0">
                                <c:forEach items="${krafn:getOptionList('org.kuali.coeus.common.impl.custom.arg.ArgValueLookupValuesFinder', paramMap)}" var="option">
                                    <c:choose>                      
                                        <c:when test="${bean.relationshipTypeBeans[valueIndex].stringValue == option.key}">
                                            <option value="${option.key}" selected>${option.value}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${option.key}">${option.value}</option>
                                        </c:otherwise>
                                    </c:choose>                    
                                </c:forEach>
                            </html:select>
