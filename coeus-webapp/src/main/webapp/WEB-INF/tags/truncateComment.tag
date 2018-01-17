<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="textAreaFieldName" required="true" %>
<%@ attribute name="action" required="true" %>
<%@ attribute name="textAreaLabel" required="true" %>
<%@ attribute name="textValue" required="true" %>
<%@ attribute name="displaySize" required="true" %>


<table border="0" cellpadding="0" cellspacing="0" style="border:none; background-image: inherit; background-position: center bottom;">
   <tbody style="background-image:inherit; background-position: center bottom;">
    <tr style="background-image:inherit; background-position: center bottom;">
        <td align="left" style="border:none; background-image: inherit; background-position: center bottom;">
            <c:choose>
	            <c:when test="${fn:length(textValue) > displaySize}">
                	  ${fn:substring(textValue,0,displaySize - 1)}...
                </c:when>
	            <c:otherwise>
                	  ${textValue}
                </c:otherwise>
            </c:choose>
        </td>
        <td style="border:none; vertical-align:bottom; background-image: inherit; background-position: center bottom;">
            <div align="right" style="background-image: inherit; background-position: center bottom;">
                <c:if test="${fn:length(textValue) > displaySize}">
                    <%-- so that the JS can grab the value from the opener...got to be a better way to do this...--%>
                    <html:hidden property="${textAreaFieldName}" write="false" styleId="${textAreaFieldName}" />
                    <kul:expandedTextArea textAreaFieldName="${textAreaFieldName}" action="${action}" textAreaLabel="${textAreaLabel}"  readOnly="true" />
                </c:if>
            </div>
        </td>
    </tr>
    </tbody>
</table>


