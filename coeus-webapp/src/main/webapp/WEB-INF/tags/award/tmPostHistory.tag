<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="tmPostHistory" value="${KualiForm.tmPostHistory}" />

<kul:tab tabTitle="Time and Money Post History" defaultOpen="${param.command eq 'displayDocSearchView' ? true : false}" >
    <div class="tab-container" align="left">
        <h3>
            <span class="subhead-left">Time and Money Post History</span>
        </h3>
        <table cellpadding=0 cellspacing=0 summary="">
            <tr>
                <th>
                    <div align="center">
                        Data retrieved
                    </div>
                </th>
                <th>
                    <div align="center"	>
                        Posted date
                    </div>
                </th>
                <th>
                    <div align="center"	>
                        Username
                    </div>
                </th>
                <th>
                    <div align="center"	>
                        First name
                    </div>
                </th>
                <th>
                    <div align="center"	>
                        Last name
                    </div>
                </th>
                <th>
                    <div align="center"	>
                        Document
                    </div>
                </th>
            </tr>
            <c:forEach items="${tmPostHistory}" var="tmPostHistory">
                <tr>
                    <td class="infoline">
                        <div align="center">
                            <c:out value="${!tmPostHistory.active}" />
                        </div>
                    </td>
                    <td class="infoline">
                        <div align="center">
                            <fmt:formatDate value="${tmPostHistory.updateTimestamp}" pattern="MM/dd/yyyy HH:mm:ss" />
                        </div>
                    </td>
                    <td class="infoline">
                        <div align="center">
                            <c:out value="${tmPostHistory.updateUser}" />
                        </div>
                    </td>
                    <td class="infoline">
                        <div align="center">
                            <c:out value="${tmPostHistory.firstName}" />
                        </div>
                    </td>
                    <td class="infoline">
                        <div align="center">
                            <c:out value="${tmPostHistory.lastName}" />
                        </div>
                    </td>
                    <td class="infoline">
                        <div align="center">
                            <a href="${ConfigProperties.application.url}/kew/DocHandler.do?command=displayDocSearchView&amp;docId=${tmPostHistory.documentNumber}"
                               target="_self" style="color:#068acd;" title="open award">${tmPostHistory.documentNumber}</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</kul:tab>

