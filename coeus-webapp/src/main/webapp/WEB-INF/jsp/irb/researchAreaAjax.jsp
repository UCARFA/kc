<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Research Area Hierarchy Ajax</title>

</head>

<body>
<html:form styleId="kualiForm" method="post"
    action="/researchAreaAjax.do" enctype=""
    onsubmit="return hasFormAlreadyBeenSubmitted();"> 

<input type="text" id = "researchAreaCode" name="researchAreaCode"   value="${ResearchAreasForm.researchAreaCode}"/>
<input type="text" id = "addRA" name="addRA"   value="${ResearchAreasForm.addRA}"/>
${ResearchAreasForm.researchAreas}


<kul:csrf />
</html:form>
</body>
</html>
