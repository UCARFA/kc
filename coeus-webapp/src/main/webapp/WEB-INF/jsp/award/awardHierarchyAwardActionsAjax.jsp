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
<title>Unit Hierarchy</title>

<style type="text/css">
/*margin and padding on body element
  can introduce errors in determining
  element position and are not recommended;
  we turn them off as a foundation for YUI
  CSS treatments. */
body {
    margin:0;
    padding:0;
}
</style>


<script language="JavaScript" type="text/javascript" src="dwr/util.js"></script>
<script language="JavaScript" type="text/javascript" src="scripts/kuali_application.js"></script>
<script type="text/javascript" src="scripts/researchareas_yui.js" ></script>


</head>

<body class=" yui-skin-sam">
<html:form styleId="kualiForm" method="post"
    action="/awardHierarchyAwardActionsAjax.do" enctype=""
    onsubmit="return hasFormAlreadyBeenSubmitted();"> 
<!--  initial data here -->
<%-- <input type="text" id = "researchAreas" name="researchAreas"   value="${ResearchAreasForm.researchAreas}"/> --%>

<div id="json">
${KualiForm.awardHierarchy}
</div>

<script type="text/javascript">

alert ("in researchareaload ");
</script>


<!--END SOURCE CODE =============================== -->
<kul:csrf />
</html:form>
</body>
</html>
