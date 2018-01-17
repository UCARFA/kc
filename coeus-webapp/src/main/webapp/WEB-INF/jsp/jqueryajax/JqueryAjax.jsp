<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ page language="java" %> 
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Jquery Ajax</title>

</head>

<body>
<html:form styleId="kualiForm" method="post"
    action="/jqueryAjax.do" enctype=""
    onsubmit="return hasFormAlreadyBeenSubmitted();">
     
<span id = "ret_value">	${KualiForm.returnVal} </span>
<span id = "code_value">${KualiForm.code} </span>

<kul:csrf />
</html:form>
</body>
</html>
