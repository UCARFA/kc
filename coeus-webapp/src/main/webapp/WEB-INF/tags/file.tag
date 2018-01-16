<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="property" required="true" %>

<%-- THIS TAG IS NOT A STANDARD PART OF RICE.  THIS IS A KC EXTENSION --%>

<%-- attachment file error handling logic start--%>
    <kul:checkErrors keyMatch="${property}" auditMatch="${property}"/>
    <%-- highlighting does not work in firefox but does in ie... --%>
    <c:set var="textStyle" value="${hasErrors == true ? 'background-color:#FFD5D5' : ''}"/>
<%-- attachment file error handling logic end--%>
                        
<html:file property="${property}" style="${textStyle}" />
