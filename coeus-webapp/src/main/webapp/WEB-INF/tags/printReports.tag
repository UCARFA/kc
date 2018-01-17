<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="requestUri" required="true" %>

<c:set var="personAttributes" value="${DataDictionary.KcPerson.attributes}" />

<div align="center">
    <table cellpadding="0" cellspacing="0" summary="">
        <tr>
            <td>
                <kul:innerTab parentTab="Print Forms" tabTitle="Print Reports" defaultOpen="false" tabErrorKey="">
                    <div class="innerTab-container" align="center" >
                        <table align="right" cellpadding="0" cellspacing="0" summary="">
                            <tbody>
                                    <kra:currentOrPendingReport title="Current Report" methodName="prepareCurrentReport" printPdfMethodName="printCurrentReportPdf" requestUri="${requestUri}" />
                                    <kra:currentOrPendingReport title="Pending Report" methodName="preparePendingReport" printPdfMethodName="printPendingReportPdf" requestUri="${requestUri}" />

                                    <c:set var="showCurrentReport" value='${currentReportRows != null}'/>
                                    <c:set var="showPendingReport" value='${pendingReportRows != null}'/>
                                    
                                    <c:if test="${showCurrentReport || showPendingReport}">
                                        <tr>
                                            <td colspan="4">
                                                <c:if test='${showCurrentReport}'>
                                                    <strong>Current Support - ${reportPersonName}</strong><br/>
                                                    <display:table class="datatable-100" cellspacing="0" cellpadding="0" name="${currentReportRows}"
                                                        id="row" export="true" pagesize="100" requestURI="${requestUri}?methodToCall=prepareCurrentReport" requestURIcontext="true" >
                                                        <c:forEach items="${row.columns}" var="column" varStatus="loopStatus">
															<%--NOTE: DO NOT FORMAT THIS FILE, DISPLAY:COLUMN WILL NOT WORK CORRECTLY IF IT CONTAINS LINE BREAKS --%>
                                                            <display:column style="text-align: center;" sortable="${column.sortable}" title="${column.columnTitle}" comparator="${column.comparator}" maxLength="${column.maxLength}" decorator="org.kuali.rice.kns.web.ui.FormatAwareDecorator"><c:out value="${column.propertyValue}" escapeXml="true" default="&nbsp;" /></display:column>
															<%--NOTE: DO NOT FORMAT THIS FILE, DISPLAY:COLUMN WILL NOT WORK CORRECTLY IF IT CONTAINS LINE BREAKS --%>
                                                        </c:forEach>
                                                        <display:setProperty name="export.csv.include_header" value="true"/>
                                                    </display:table>
                                                </c:if>
                                                <c:if test='${showPendingReport}'>
                                                    <strong>Pending Support - ${reportPersonName}</strong><br/>
                                                     <display:table class="datatable-100" cellspacing="0" cellpadding="0" name="${pendingReportRows}"
                                                                    id="row" export="true" pagesize="100" requestURI="${requestUri}?methodToCall=preparePendingReport=" requestURIcontext="true" >
                                                         <c:forEach items="${row.columns}" var="column" varStatus="loopStatus">
															<%--NOTE: DO NOT FORMAT THIS FILE, DISPLAY:COLUMN WILL NOT WORK CORRECTLY IF IT CONTAINS LINE BREAKS --%>
                                                        	<display:column sortable="${column.sortable}" title="${column.columnTitle}" comparator="${column.comparator}" maxLength="${column.maxLength}" class="" decorator="org.kuali.rice.kns.web.ui.FormatAwareDecorator"><c:out value="${column.propertyValue}" escapeXml="true" default="&nbsp;" /></display:column>
															<%--NOTE: DO NOT FORMAT THIS FILE, DISPLAY:COLUMN WILL NOT WORK CORRECTLY IF IT CONTAINS LINE BREAKS --%>
                                                        </c:forEach>
                                                        <display:setProperty name="export.csv.include_header" value="true"/>
                                                    </display:table>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:if>
                            </tbody>
                        </table>
                    </div>
                </kul:innerTab>
            </td>
        </tr>
    </table>  
</div>
